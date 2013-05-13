
public class SudokuBoard {
		
	int[][] boardArray;
	
	public SudokuBoard() {
		boardArray = new int[9][9];
	}
	void setNumber (int x, int y, int number) {
		boardArray[x][y] = number;;
	}

	int getNumber (int x, int y) {
		return boardArray[x][y];
	}

}
