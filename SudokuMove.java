/**
 * The SudokuMove class is an object representing a single digit placement while solving a Sudoku puzzle
 * (e.g., the placement of the digit 8 in row 3, column 5 of the grid), to be used by the solver.
 * 
 * @author Edwin Sanchez Huizar
 *
 */
public class SudokuMove {

	private int row;

	private int col;

	private int num;

	/**
	 * The SudokuMove constructor takes in a row, column, and number and initializes them to the corresponding
	 * instance variables. 
	 * 
	 * @param row - the given row
	 * @param col - the given column
	 * @param num - the given number.
	 */
	public SudokuMove(int row, int col, int num) {
		this.row = row;
		this.col = col;
		this.num = num;
	}

	/**
	 * The meaning of Encapsulation, is to make sure that "sensitive" data is hidden from users. Thus, the 
	 * the SudokuMove's row is declared as a private attribute and the get method allows the user to
	 * access the private variable.
	 * 
	 * @return the row placement.
	 */
	public int getRow() {
		return row;
	}

	/**
	 * The meaning of Encapsulation, is to make sure that "sensitive" data is hidden from users. Thus, the 
	 * the SudokuMove's column is declared as a private attribute and the get method allows the user to
	 * access the private variable.
	 * 
	 * @return the column placement.
	 */
	public int getCol() {
		return col;
	}

	/**
	 * The meaning of Encapsulation, is to make sure that "sensitive" data is hidden from users. Thus, the 
	 * the SudokuMove's number is declared as a private attribute and the get method allows the user to
	 * access the private variable.
	 * 
	 * @return the number.
	 */
	public int getNum() {
		return num;
	}
}
