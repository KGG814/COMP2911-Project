/*
 * The Sudoku GUI
 * @author Daniel
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;

public class SudokuGUI {

  private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SudokuGUI window = new SudokuGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SudokuGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 592, 406);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnGetHint = new JButton("Get Hint");
		btnGetHint.setBounds(340, 11, 89, 23);
		frame.getContentPane().add(btnGetHint);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(439, 11, 89, 23);
		frame.getContentPane().add(btnQuit);
		
		createBoard();
	}
	
	/*
	 * Creates the sudoku board
	 */
	private void createBoard() {
		createSquare(10, 10);
		createSquare(10, 112);
		createSquare(10, 214);
		createSquare(112, 10);
		createSquare(112, 112);
		createSquare(112, 214);
		createSquare(214, 10);
		createSquare(214, 112);
		createSquare(214, 214);
		
	}
	
	/*
	 * create a square with the given row and column number on the screen
	 */
	private void createSquare(int row, int column) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
			JFormattedTextField formattedTextField = new JFormattedTextField();
			//only accept one number
			try {
				formattedTextField.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("#")));
	        } catch (java.text.ParseException ex) {
	        }
	        formattedTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
			formattedTextField.setBounds(row+(i*33), column+(j*33), 32, 32);
			frame.getContentPane().add(formattedTextField);
			}
		}
	}
}
