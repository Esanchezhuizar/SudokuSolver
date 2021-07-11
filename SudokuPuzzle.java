import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * The SudokuPuzzle class implements a representation of the sudoku puzzle through a 2D array. It 
 * contains methods that check whether or not a given move is valid in its current grid configuration. Moreover, 
 * the class provides an equals method that compared the solved puzzle to a known solution to verify if it's correct.
 * The toString method is a string representation of the sudokuPuzzle.
 *  
 * @author Edwin Sanchez Huizar
 *
 */
public class SudokuPuzzle {

	private int NUM_ROWS = 9;

	private int NUM_COLS = 9;

	private int[][] sudokuPuzzle = new int[NUM_ROWS][NUM_COLS];

	private static Scanner scan = new Scanner(System.in);

	/**
	 * The SudokuPuzzle constructor takes in a puzzle file name and reads the file to
	 * initialize the 2D array (sudokuPuzzle).
	 * 
	 * @param puzzleFile - the name of the given puzzle file.
	 */
	public SudokuPuzzle(File puzzleFile) {

		try {
			scan = new Scanner(puzzleFile);
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}
		while (scan.hasNextInt()) {
			for (int r = 0; r < NUM_ROWS; r++) {
				for (int c = 0; c < NUM_COLS; c++ ) {
					sudokuPuzzle[r][c] = scan.nextInt();
				}
			}
		}

		scan.close();
	}

	/**
	 * The equals method checks whether two SudokuPuzzle objects are equivalent (e.g., the solved puzzle and 
	 * the known solution to the puzzle). Returns true or false depending if the two puzzles match.
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj instanceof SudokuPuzzle) {
			SudokuPuzzle otherPuzzle = (SudokuPuzzle) obj; //casting is safe
			int count = 0;
			for (int i = 0; i < NUM_ROWS; i++) {
				for (int j = 0; j < NUM_COLS; j++) {
					if (sudokuPuzzle[i][j] == otherPuzzle.sudokuPuzzle[i][j]) { 
						count++;
					}
				}
			}
			if (count == (NUM_ROWS * NUM_COLS)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * The isEmpty method checks if there is an existing number in SudoKuPuzzle Cell.
	 * 
	 * @param row - the given row
	 * @param col - the given column
	 * @return True/False depending whether or not the cell is empty, respectively.
	 */
	public boolean isEmpty (int row, int col) {

		if (sudokuPuzzle[row][col] == 0) {
			return true;
		}

		return false;
	}

	/**
	 * The isInRow method checks whether a given number exist in the given row.
	 * 
	 * @param row - the given row
	 * @param num - the given number
	 * @return True/False depending whether or not the number exist in the row, respectively.
	 */
	public boolean isInRow(int row, int num) {

		for (int c = 0; c < NUM_ROWS; c++)
			if (sudokuPuzzle[row][c] == num) {
				return true;
			}
		return false;
	}

	/**
	 * The isInCol method checks whether a given number exist in the given column.
	 * 
	 * @param col - the given column
	 * @param num - the given number
	 * @return True/False depending whether or not the number exist in the column, respectively.
	 */
	public boolean isInCol(int col, int num) {

		for (int r = 0; r < NUM_COLS; r++)
			if (sudokuPuzzle[r][col] == num) {
				return true;
			}
		return false;
	}

	/**
	 * The isInBox method checks whether a given number exist within a 3x3 box within the grid. The constant integer 
	 * 3 is used to calculate the box row and box column from a regular row/column cell position.
	 * 
	 * @param row - the given row
	 * @param col - the given column
	 * @param num - the given number
	 * @return True/False depending whether or not the number exist in a 3x3 box, respectively.
	 */
	public boolean isInBox(int row, int col, int num) {

		int r = row - (row % 3);
		int c = col - (col % 3);

		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				if (sudokuPuzzle[i][j] == num) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * The updateBoard method updates the SudukuPuzzle every time a new move is made. 
	 * 
	 * @param move - a sudoKuMove object representing a single digit placement.
	 */
	public void updateBoard(SudokuMove move) {
		sudokuPuzzle[move.getRow()][move.getCol()] = move.getNum();
	}

	public String toString() {

		String board = "";

		for (int r = 0; r < NUM_ROWS; r++) {
			for (int c = 0; c < NUM_COLS; c++ ) {
				if (sudokuPuzzle[r][c] == 0) {
					board += "_ ";
				}
				else {
					board += sudokuPuzzle[r][c] + " ";
				}
			}
			board += "\n";
		}
		return board.trim() + "\n";
	}	
}
