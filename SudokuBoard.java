import java.awt.*;
import java.util.LinkedList;

import javax.swing.JPanel;

/**
 * A Class to represent the sudoku board
 * This contains 9 squares
 * Each square is arranged similar to a square
 * Using a 2-dimensional array
 *  Square[rows][columns]
 */
public class SudokuBoard extends JPanel {
		
   /**
	* For some reason I have to put an ID
	*/
	private static final long serialVersionUID = 1L;
	
	private Square[][] boxes;
	
	public SudokuBoard() {
		//Set Board Properties
		setLayout(new GridLayout(3, 3, 1, 1));

		//Creates 9 squares
		boxes = new Square[3][3];
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++) {
				boxes[i][j] = new Square();
				add(boxes[i][j]);				
			}
		}
	}
	
	/**
	 * Is the row solved
	 * Checks each square in the squareRow and each row in those squares
	 * @param squareRow - corresponds to the row of squares
	 * 	0 - bottom squares, 1 - middle squares, 2 - top squares
	 * @param row - corresponds to the row in the square
	 *  0 - bottom row, 1 - middle row, 2 - top row
	 * @return if the row is solved returns true
	 */
	public boolean rowIsSolved(int squareRow, int row) {
		LinkedList<Integer> numberList = new LinkedList<Integer>();
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				//Iterates through each square in the row
				Square chosen = boxes[squareRow][i];
				//Iterates through each cell in the row
				Cell cell = chosen.getCell(row, j);
				int cellNumber = cell.getNumber();
				
				if(cellNumber == 0 || numberList.contains(cellNumber)) {
					return false;
				} else {
					numberList.add(cellNumber);
				}
			}
		}
		return true;
	}
	
	/**
	 * Is the Column Solved
	 * Checks each square in the squareColumn and each row in those squares
	 * @param squareCol - corresponds to the column of square
	 *  0 - left squares, 1 - middle squares, 2 - right squares
	 * @param col - corresponds to the column in the square
	 *  0 - left column, 1 - middle column, 2 - right column
	 * @return if the column is solved returns true
	 */
	public boolean columnIsSolved(int squareCol, int col) {
		LinkedList<Integer> numberList = new LinkedList<Integer>();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				Square chosen = boxes[i][squareCol];
				Cell cell = chosen.getCell(j, col);
				int cellNumber = cell.getNumber();
				if(cellNumber == 0 || numberList.contains(cellNumber)) {
					return false;
				} else {
					numberList.add(cellNumber);
				}
			}
		}		
		return true;
	}
	
	/**
	 * Is the square solved
	 * @param squareRow - row coordinate
	 * @param squareCol - column coordinate
	 * @return true if square is solved
	 */
	public boolean squareIsSolved(int squareRow, int squareCol) {
		Square square = boxes[squareRow][squareCol];
		return square.isSolved();
	}
	
	/**
	 * Is the puzzle Solved
	 * Checks if each row, column and square is solved
	 * @return true is puzzle is solved
	 */
	public boolean isSolved() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(!rowIsSolved(i, j) || !columnIsSolved(i, j) || !squareIsSolved(i, j)) {
					return false;
				}
			}
		}
		return true;
	}
}
