
import java.io.File;
import java.util.Scanner;

/**
 * The main method reads in the puzzle file and solution (if given), uses 
 * a SudokuSolver to solve the puzzle, and produces the program output (e.g if solution is given, 
 * it compares solutions. Otherwise, it prints out the solved puzzle).
 * 
 * @author Edwin Sanchez Huizar
 *
 */
public class SudokuTest {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter filename of puzzle: ");
		System.out.println("Enter filename of solution (optional): ");

		File puzzleName = new File("puzzles/" + scan.next() + ".txt");
		SudokuPuzzle startingPuzzle = new SudokuPuzzle(puzzleName);
		SudokuSolver puzzleSolver = new SudokuSolver(startingPuzzle);
		System.out.println("Starting puzzle:\n" + startingPuzzle);
		puzzleSolver.solve();
		System.out.println("Solved Puzzle: \n" + startingPuzzle);

		if (scan.hasNext()) {
			File solvedPuzzleName = new File("puzzles/" + scan.next() + ".txt");
			SudokuPuzzle solvedPuzzle = new SudokuPuzzle(solvedPuzzleName);

			if (startingPuzzle.equals(solvedPuzzle)) {
				System.out.println("Solution is correct!");			
			}
			else {
				System.out.println("Solution is not correct!");			
			}
		}

		scan.close();
	}
}
