import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The GUI Class to hold everything for the sudoku puzzle
 * which includes the sudoku board, buttons and images if
 * we want
 *
 */
public class SudokuGUI extends JFrame {
	
	Cell[][] boardArray;
	/**
	 * For some reason I have to put an ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Puts everything on the JFrame
	 */
	public SudokuGUI() {
		for (int col = 0; col < 9; col++){
			for (int row = 0; row < 9; row++) {
				boardArray[col][row] = new Cell();
			}
		}
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JPanel boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(9, 9, 1, 1));
		JPanel buttons = setButtons();
		panel.add(boardPanel);
		panel.add(buttons);
		add(panel);
		
		//Set JFrame Properties
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width / 2 - 175), (d.height / 2 - 275));
		setResizable(true);
		setVisible(true);
	}
	
	/**
	 * 
	 * @return A JPanel that creates all the buttons
	 */
	public JPanel setButtons() {
		JPanel buttons = new JPanel();
		
		JButton New = new JButton("New");
		JButton GetHint = new JButton("Get Hint");
		JButton Check = new JButton("Check");
		buttons.add(New);
		buttons.add(GetHint);
		buttons.add(Check);
		
		return buttons;
	}

	public void populateBoard (SudokuBoard board) {
		for (int col = 0; col<9; col++) {
			for (int row = 0; row<9; row++){
				boardArray[col][row].setNumber(board.getNumber(col, row));
			}
		}
	}
}
