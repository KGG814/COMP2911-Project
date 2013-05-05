import java.awt.*;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * A Class to represent a square in the sudoku board
 * A square is a JPanel that contain 9 Cells/JTextBox
 * Each cell is in the 2-dimensional array cells
 * 	 cells[rows][columns]
 * 
 * 		2 |_|_|_|
 * 		1 |_|_|_|
 * 		0 |_|_|_|
 * 		   0 1 2
 */
public class Square extends JPanel{
	/**
	 * For some reason I have to put an ID
	 */
	private static final long serialVersionUID = 1L;
	private Cell[][] cells;
	
	public Square() {
		
		//Create All cells in square
		cells = new Cell[3][3];
		for(int i = 0; i < 3; i++) {
		    for(int j = 0; j < 3; j++) {
				Cell cell = new Cell();
				add(cell);		    	
		    }
		}	
		
		//JPanel Properties
		setLayout(new GridLayout(3, 3, 1, 1));
		setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
	}

	/**
	 * Is the square solved
	 * @return if the square is solved
	 */
	public boolean isSolved() {
		LinkedList<Integer> numberList = new LinkedList<Integer>();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				int cellNumber = cells[i][j].getNumber();
				if(cellNumber == 0 || numberList.contains(cellNumber)){
					return false;
				} else {
					numberList.add(cellNumber);
				}
			}
		}
		
		return true;
	}
	
	/**
	 * Given coordinates,
	 * @param row  and 
	 * @param col
	 * @return the corresponding cell in the square
	 * 
	 * E.g. getCell(1, 2)
	 *  corresponds to the cell marked with X.	
	 * 		2 |_|_|_|
	 * 		1 |_|_|X|
	 * 		0 |_|_|_|
	 * 		   0 1 2	
	 */
	public Cell getCell(int row, int col) {
		return cells[row][col];
	}
}
