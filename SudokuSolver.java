import java.util.ArrayDeque;
import java.util.Deque;

/**
 * The SudokuSolver class solves a given SudokuPuzzle using backtracking. This class implements the Deque interface,
 * which represents a linear collection that supports access at either end (either the start of end of the collection). 
 * Since Deque is just an interface, the ArrayDeque is used as the actual data structure.
 * 
 * @author Edwin Sanchez Huizar
 *
 */
public class SudokuSolver {

	private Deque<SudokuMove> sudoku = new ArrayDeque<SudokuMove>();

	private int NUM_ROWS = 9;

	private int NUM_COLS = 9;

	private int MAX_DIGIT = 9;

	private int EMPTY_CELL = 0;

	private int STARTING_NUM = 0;

	SudokuPuzzle newPuzzle;

	/**
	 * 
	 * The SudokuSolver constructor takes in a SudokuPuzzle to solve and initializes them it (stores it) to the corresponding
	 * instance variable. 
	 * 
	 * @param puzzle - the given SudokuPuzzle
	 */
	public SudokuSolver(SudokuPuzzle puzzle) {
		newPuzzle = puzzle;
	}

	/**
	 * The solve method solves the sudoKuPuzzle by running the backtracking algorithm. Backtracking occurs when 
	 * its unable to find a valid number for some empty cell. The helper method (nextMove) determines the next move to make 
	 * and signals when backtracking is needed.
	 * 
	 */
	public void solve() {

		for(int row = 0; row < NUM_ROWS; row++){
			for(int column = 0; column < NUM_COLS; column++) {
				if(newPuzzle.isEmpty(row, column) && nextMove(row, column, STARTING_NUM) == false) {
					SudokuMove lastMove = sudoku.pop();
					row = lastMove.getRow();
					column = lastMove.getCol();
					while(!nextMove(row, column, lastMove.getNum())) { 
						lastMove = sudoku.pop(); 
						row = lastMove.getRow();
						column = lastMove.getCol();
					}
				}
			}
		}
	}
	
	/**
	 * The helper method assist with the solving method, determines the next move that should be made by 
	 * calling the methods that check validity. The method creates a sudokuMove object every time a move is made 
	 * and pushes to the ArrayDeque. 
	 * 
	 * @return True/False if a move can be made on a given cell. Signals to the Solve method when backtracking
	 * is needed when it returns false.
	 */
	private boolean nextMove(int row, int col, int num) {

		for(int i=num+1; i <= MAX_DIGIT; i++) {
			if(!newPuzzle.isInRow(row, i) && !newPuzzle.isInCol(col, i) && !newPuzzle.isInBox(row, col, i)) {
				SudokuMove newMove = new SudokuMove(row, col, i);
				sudoku.push(newMove);
				newPuzzle.updateBoard(newMove);
				return true;
			}
		}
		//resets the cell to zero
		SudokuMove newMove = new SudokuMove(row, col, EMPTY_CELL);
		newPuzzle.updateBoard(newMove);
		return false;
	}

}
