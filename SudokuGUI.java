import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;

/**
 * The GUI Class to hold everything for the sudoku puzzle
 * which includes the sudoku board, buttons and images if
 * we want
 *
 */
public class SudokuGUI extends JFrame {

	
	/**
	 * For some reason I have to put an ID
	 */
	private static final long serialVersionUID = 1L;
	JFormattedTextField[][] boardArray;
	
	/**
	 * Puts everything on the JFrame
	 */
	public SudokuGUI() {

		boardArray = new JFormattedTextField[9][9];
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JPanel sudokuBoard = setBoard();
		JPanel buttons = setButtons();
		JPanel numbers = setNumButtons();
		JPanel other = new JPanel();

		other.setLayout(new GridLayout(3, 3));
		other.add(numbers);
		other.add(buttons);

		panel.add(sudokuBoard);
		panel.add(other);

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
	
	public JPanel setBoard() {
		
		boardArray = new Cell[9][9];
		
		JPanel board = new JPanel();
		board.setLayout(new GridLayout(9, 9, 1, 1));
		
		for (int col = 0; col < 9; col++){
			for (int row = 0; row < 9; row++) {
				boardArray[col][row] = new JFormattedTextField();
				board.add(boardArray[col][row]);
			}
		}
		
		return board;
	}
	
	public JPanel setNumButtons() {

		JPanel numbers = new JPanel();
		numbers.setLayout(new GridLayout(3, 3));

		JButton one = new JButton("1");
		JButton two = new JButton("2");
		JButton three = new JButton("3");
		JButton four = new JButton("4");
		JButton five = new JButton("5");
		JButton six = new JButton("6");
		JButton seven = new JButton("7");
		JButton eight = new JButton("8");
		JButton nine = new JButton("9");
		
		numbers.add(one);
		numbers.add(two);
		numbers.add(three);
		numbers.add(four);
		numbers.add(five);
		numbers.add(six);
		numbers.add(seven);
		numbers.add(eight);
		numbers.add(nine);

		return numbers;

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
				//want to out
				String number = Integer.toString(board.getNumber(col, row));
				boardArray[col][row].setText(number);
			}
		}
	}
}
