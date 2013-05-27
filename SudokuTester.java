import java.io.IOException;

public class SudokuTester {
	public static void main(String[] args) throws IOException {
		SudokuGenerator generator = new SudokuGenerator(4);
		generator.GenerateSolvableSudoku();
		generator.solution.printBoard();
		System.out.print("\n");
		generator.board.printBoard();
		SudokuBoard board = generator.getBoard();
		SudokuSolver solver = new SudokuSolver(board);
		solver.runSolve();
		System.out.print("\n");
		solver.getSolution().printBoard();
		solver.runSolve();
		System.out.print("\n");
		solver.getSolution().printBoard();
	}
}
