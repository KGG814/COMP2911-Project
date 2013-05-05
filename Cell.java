import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 * A class to represent a cell in a sudoku board
 * A cell itself is a textbox to input the number entered
 * It also holds a number the number in the cell
 * If there is no number entered, then it is 0.
 * 
 * TODO 
 * Stop beeping when a number is entered
 * Make editable and non-ediatble cells.
 */
public class Cell extends JFormattedTextField{
  
	/**
	 * For some reason I have to put an ID
	 */
	private static final long serialVersionUID = 1L;
	private int number = 0;
	
	public Cell() {
		//only accept one number
		try {
			setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("#")));
        	} catch (java.text.ParseException ex) {}
        	
 
        
		addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				// Only allow numeric input
				boolean editable = true;
				if (editable) {
					if (e.getKeyChar() >= '1' && e.getKeyChar() <= '9') {
						setEditable(true);
						setNumber(e.getKeyChar() - 48);
					} else {
						setEditable(false);
					}
				}
			}
		});
		
		//Set Cell Properties
		setHorizontalAlignment(javax.swing.JTextField.CENTER);
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		setPreferredSize(new Dimension(35, 35));
		setFont(new Font("Lucida Console", Font.BOLD, 18));
	}
	
	/**
	 * Sets the number of the cell and outputs the number in the cell
	 * @param num - the number of the cell
	 */
	public void setNumber(int num) {
		number = num;
		setText(String.valueOf(number));
	}
	
	/**
	 * Deletes the number in the cell and outputs nothing in the cell
	 * when there is nothing in the cell, it is 0
	 */
	public void deleteNumber() {
		number = 0;
		setText("");
	}
	
	/**
	 * 
	 * @return the cell number
	 */
	public int getNumber() {
		return number;
	}

}
