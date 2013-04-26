import java.util.LinkedList;


public class Square {
	final int[][] squareArray;
	Square (SudokuBoard board, int squareNumber) {
		squareArray = new int[3][3];
		int squareRow;
		int squareColumn;
		if (squareNumber <= 2) {
			squareRow = 0;
		} else if (squareNumber <= 5) {
			squareRow = 1;
		} else {
			squareRow = 2;
		}
		squareColumn = squareNumber%3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				squareArray[i][j] = board.getNumber(squareColumn*3+i,squareRow*3+j);
			}
		}
	}
	
	boolean isSolved() {
		LinkedList<Integer> numberList = new LinkedList<Integer>();
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++) {
				if (squareArray[i][j]==0||numberList.contains(squareArray[i][j])) {
					return false;
				} else {
					numberList.add(squareArray[i][j]);
				}
			}
		}
		return true;
	}
	
}
