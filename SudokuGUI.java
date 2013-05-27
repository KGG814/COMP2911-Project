import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	
	/**
	 * For some reason I have to put an ID
	 */
	private static final long serialVersionUID = 1L;
	private BoardGUI sudokuBoard;
	
	/**
	 * Puts everything on the JFrame
	 */
	public SudokuGUI() {
		
		JPanel panel = new JPanel();
		//panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		sudokuBoard = new BoardGUI();
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
		buttons.setLayout(new GridLayout(3, 2, 10, 10));
		Dimension size = new Dimension(90, 40);
		
		JButton New = new JButton("New");
		New.setPreferredSize(size);
		New.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				//add something
				new SudokuGUI();
				dispose();
		    }
		});
		
		JButton GetHint = new JButton("Get Hint");
		GetHint.setPreferredSize(size);
		GetHint.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				//add something
		    }
		});
		
		JButton Undo = new JButton("Undo");
		Undo.setPreferredSize(size);
		Undo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				//add something
				sudokuBoard.deleteCell();
		    }
		});	
		
		JButton Solve = new JButton("Solve");
		Solve.setPreferredSize(size);
		Solve.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				//add something
		    }
		});
		
		JButton Options = new JButton("Options");
		Options.setPreferredSize(size);
		Options.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				//add something
		    }
		});	
		
		buttons.add(New);
		buttons.add(GetHint);
		buttons.add(Undo);
		buttons.add(Solve);
		buttons.add(Options);

		return buttons;
	}

}
