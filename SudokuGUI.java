import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



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
	private BoardGUI sudokuBoard;
	private SolutionGUI currentSolution;
	private int difficulty;
	private int hints;
	/**
	 * Puts everything on the JFrame
	 */
	public SudokuGUI(int difficulty) {

		JPanel panel = new JPanel();
		//panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		this.difficulty = difficulty;
		hints = 2*difficulty;
		sudokuBoard = new BoardGUI(difficulty);
		JPanel buttons = setButtons();

		panel.add(sudokuBoard);
		panel.add(buttons);
		add(panel);

		//Set JFrame Properties
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width / 2 - 275), (d.height / 2 - 275));
		setResizable(true);
		setVisible(true);
	}

	public SudokuGUI(int[][] boardArray, int difficulty) {

		JPanel panel = new JPanel();
		//panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		this.difficulty = difficulty;
		hints = 2*difficulty;
		sudokuBoard = new BoardGUI(boardArray, difficulty);
		JPanel buttons = setButtons();

		panel.add(sudokuBoard);
		panel.add(buttons);
		add(panel);

		//Set JFrame Properties
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width / 2 - 275), (d.height / 2 - 275));
		setResizable(true);
		setVisible(true);
	}
	/**
	 * 
	 * @return A JPanel that creates all the buttons
	 */
	public JPanel setButtons() {
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(4, 2, 10, 10));
		Dimension size = new Dimension(120, 40);

		JButton New = new JButton("New");
		New.setPreferredSize(size);
		New.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				//add something
				new SudokuGUI(difficulty);
				dispose();
		    }
		});
		
		//JLabel numHints = new JLabel("Hints:");

		//put display for number of hints left
		JButton GetHint = new JButton("Get Hint");
		GetHint.setPreferredSize(size);
		GetHint.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				if(hints != 0) {
					sudokuBoard.displayHint();
					hints--;
				}
		    }
		});

		JButton Delete = new JButton("Delete");
		Delete.setPreferredSize(size);
		Delete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				//add something
				sudokuBoard.deleteCell();
		    }
		});	

		JButton Solve = new JButton("Check");
		Solve.setPreferredSize(size);
		Solve.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				//add something
				if (sudokuBoard.checkSolution()) {
					//instead of dispose call the saveRecord if it is correct
					//open new window and have textfield to save name.
					JFrame success = new JFrame();
					success.setVisible(true);
				}
		    }
		});

		JButton Solution = new JButton("Solution");
		Solution.setPreferredSize(size);
		Solution.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				if (currentSolution!=null) {
					currentSolution.dispose();
				}
				currentSolution = new SolutionGUI(sudokuBoard.getSolution());

		    }
		});
		
		JButton Back = new JButton("Back");
		Back.setPreferredSize(size);
		Back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				dispose();
				new MainMenu();
		    }
		});
		
		JButton Save = new JButton("Save");
		Save.setPreferredSize(size);
		Save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				try {
					sudokuBoard.save();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});
		
		//buttons.add(numHints);
		buttons.add(New);
		buttons.add(GetHint);
		buttons.add(Delete);
		buttons.add(Solve);
		buttons.add(Solution);
		buttons.add(Back);
		buttons.add(Save);

		return buttons;
	}

}
