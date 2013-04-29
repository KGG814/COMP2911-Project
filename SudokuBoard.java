import java.util.LinkedList;

/**
 * This is a class to store the data for the Sudoku Board. Feel free to edit this, 
 * or not use it all for the project.
 * @author Kalana
 *
 */

public class SudokuBoard {
	int[][] boardArray;
	SudokuBoard () {
		boardArray = new int[9][9];
	}
	/**
	 * Sets the number at coordinate x,y
	 * 0,0 is in the bottom left corner
	 * @param x horizontal position of Sudoku tile
	 * @param y vertical position of Sudoku tile
	 * @param number the number that will be placed
	 */
	void setNumber (int x, int y, int number) {
		boardArray[x][y] = number;
	}
	/**
	 * Returns the 3*3 square corresponding to squareNumber.
	 * Squares are numbered left to right, top to bottom :
	 * 6 7 8
	 * 3 4 5
	 * 0 1 2
	 * @param squareNumber the number of the corresponding 3x3 square
	 * @return a 3x3 square
	 */
	int getNumber (int x, int y) {
		return boardArray[x][y];
	}
	
	private boolean rowIsSolved (int row) {
		LinkedList<Integer> numberList = new LinkedList<Integer>();
		int currentNumber;
		for (int i = 0; i < 9; i++){
			currentNumber = boardArray[i][row];
			if (currentNumber<1||currentNumber>9||
				numberList.contains(currentNumber)) {
				return false;
			} else {
				numberList.add(currentNumber);
			}
		}
		return true;
	}
	
	private boolean columnIsSolved (int column) {
		LinkedList<Integer> numberList = new LinkedList<Integer>();
		int currentNumber;
		for (int j = 0; j < 9; j++){
			currentNumber = boardArray[column][j];
			if (currentNumber<1||currentNumber>9||
				numberList.contains(currentNumber)) {
				return false;
			} else {
				numberList.add(currentNumber);
			}
		}
		return true;
	}
	
	boolean diagonalIsSolved (int diagonal) {
		LinkedList<Integer> numberList = new LinkedList<Integer>();
		int currentNumber;
		if (diagonal==0) {
			for (int i = 0; i < 9; i++){
				currentNumber = boardArray[i][i];
				if (currentNumber<1||currentNumber>9||
					numberList.contains(currentNumber)) {
					return false;
				} else {
					numberList.add(currentNumber);
				}
			}
		} else if (diagonal==1) {
			for (int i = 8; i >=0; i--){
				currentNumber = boardArray[i][8-i];
				if (currentNumber<1||currentNumber>9||
					numberList.contains(currentNumber)) {
					return false;
				} else {
					numberList.add(currentNumber);
				}
			}
		}
		return true;
	}
	
	boolean isSolved () {
		for (int i = 0; i<9; i++) {
			Square checkSquare = new Square(this, i);
			if(!rowIsSolved(i)||!columnIsSolved(i)||!checkSquare.isSolved()) {
				return false;
			}
		}
		if(!diagonalIsSolved(0)||!diagonalIsSolved(1)) {
			return false;
		}
		return true;
	}
	
}

