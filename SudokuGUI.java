import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



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
	
	private MainMenu menu;
	private BoardGUI sudokuBoard;
	private SolutionGUI currentSolution;
	private int difficulty;
	private int hints;
	private JLabel diffLabel;
	private JLabel hintLabel;
	private ClockLabel clock;
	
	/**
	 * Puts everything on the JFrame
	 */
	public SudokuGUI(int difficulty, MainMenu menu) {

		this.difficulty = difficulty;
		this.hints = 2 * difficulty;
		this.menu = menu;
		this.sudokuBoard = new BoardGUI(difficulty);
		
    	setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("ui/b2.jpg")));	
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JPanel panel = new JPanel();
    	panel.setBackground(new Color(255, 231, 186));
		JPanel buttons = setButtons(0);
		panel.add(sudokuBoard);
		panel.add(buttons);
		add(panel, BorderLayout.CENTER);

		//Set JFrame Properties
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setSize(700, 480);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width / 2 - 360), (d.height / 2 - 260));
		setResizable(true);
		setVisible(true);
		
	}
	
	/**
	 * Constructor used when loading a saved sudoku board
	 * @param boardArray
	 * @param difficulty
	 * @param editableArray
	 * @param menu
	 */
	public SudokuGUI(int[][] boardArray, int difficulty, 
			int[][] editableArray, MainMenu menu, int time, int hints) {
		
		this.difficulty = difficulty;
		this.hints = hints;
		this.menu = menu;
		sudokuBoard = new BoardGUI(boardArray, difficulty, editableArray);
		
    	setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("ui/b2.jpg")));	
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	panel.setBackground(new Color(255, 231, 186));
		JPanel buttons = setButtons(time);
		panel.add(sudokuBoard);
		panel.add(buttons);
		add(panel, BorderLayout.CENTER);
		
		//Set JFrame Properties
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setSize(800, 480);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width / 2 - 360), (d.height / 2 - 260));
		setResizable(true);
		setVisible(true);
		
	}
	
	/**
	 * 
	 * @return A JPanel the side panel used to store all the options available
	 * during the game
	 * Includes: 
	 */
	public JPanel setButtons(int time) {
		JPanel buttons = new JPanel();
    	buttons.setLayout(new GridBagLayout());
    	buttons.setBackground(new Color(255, 231, 186));
    	GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        
        clock = new ClockLabel(time);
        gbc.weightx = 0.5;
		gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.ipady = 15;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buttons.add(clock, gbc);
        
        diffLabel = new JLabel("Difficulty: " + Integer.toString(difficulty));
        diffLabel.setFont(new Font("Arial", Font.BOLD, 17));
        gbc.weightx = 0.5;
		gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.ipady = 15;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buttons.add(diffLabel, gbc);
        
        hintLabel = new JLabel("Hints: " + Integer.toString(hints));
        hintLabel.setFont(new Font("Arial", Font.BOLD, 17));
        gbc.weightx = 0.5;
		gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.ipady = 15;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buttons.add(hintLabel, gbc);
        
		JButton New = new JButton("New");
		New.setFont(new Font("Arial", Font.BOLD, 15));
		gbc.weightx = 0.5;
		gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.ipady = 15;
        gbc.fill = GridBagConstraints.HORIZONTAL;
		New.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				//add something
				new SudokuGUI(difficulty, menu);
				dispose();
		    }
		});
		buttons.add(New, gbc);
		
		JButton Reset = new JButton("Reset");
		Reset.setFont(new Font("Arial", Font.BOLD, 15));
		gbc.weightx = 0.5;
		gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.ipady = 15;
        gbc.fill = GridBagConstraints.HORIZONTAL;		
        Reset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				sudokuBoard.reset();
		    }
		});
        buttons.add(Reset, gbc);

		//put display for number of hints left
		JButton GetHint = new JButton("Get Hint");
		GetHint.setFont(new Font("Arial", Font.BOLD, 15));
		gbc.weightx = 0.5;
		gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.ipady = 15;
        gbc.fill = GridBagConstraints.HORIZONTAL;		
        GetHint.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				if(hints != 0) {
					sudokuBoard.displayHint();
					hints--;
					hintLabel.setText("Hints: " + Integer.toString(hints));
				}
		    }
		});
        buttons.add(GetHint, gbc);

		JButton Delete = new JButton("Delete");
		Delete.setFont(new Font("Arial", Font.BOLD, 15));
		gbc.weightx = 0.5;
		gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.ipady = 15;
        gbc.fill = GridBagConstraints.HORIZONTAL;		
        Delete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				//add something
				sudokuBoard.deleteCell();
		    }
		});	
        buttons.add(Delete, gbc);

		JButton Solve = new JButton("Check");
		Solve.setFont(new Font("Arial", Font.BOLD, 15));
		gbc.weightx = 0.5;
		gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.ipady = 15;
        gbc.fill = GridBagConstraints.HORIZONTAL;		
        Solve.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				//add something
				final JFrame answer = new JFrame();
				answer.setLayout(new FlowLayout(FlowLayout.CENTER));
				answer.pack();

				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
				answer.setLocation((d.width - 800), (d.height / 2 - 100));
				answer.setResizable(true);
				answer.setVisible(true);
				JPanel panel = new JPanel();
				if (!sudokuBoard.checkSolution()) {
					//instead of dispose call the saveRecord if it is correct
					//open new window and have textfield to save name.
					answer.setTitle("SUCCESS :)");

					panel.setLayout(new GridBagLayout());
			    	GridBagConstraints gbc = new GridBagConstraints();
			        gbc.insets = new Insets(5,5,5,5);
			        
					JLabel success = new JLabel("Board is Solved. Congratulations!!");
					success.setFont(new Font("Arial", Font.BOLD, 17));
					gbc.gridx = 0;
			    	gbc.gridy = 0;
			    	gbc.gridwidth = 2;
			    	panel.add(success, gbc);
			    	
			    	JLabel enter = new JLabel("Enter Name:");
			    	gbc.gridx = 0;
			    	gbc.gridy = 2;
			    	gbc.gridwidth = 2;
			    	panel.add(enter, gbc);
			    	
					JTextField name = new JTextField();
					name.addKeyListener(new KeyListener() 
					{

						@Override
						public void keyPressed(KeyEvent arg0) {
							// TODO Auto-generated method stub
							//Prevents from entering a name that is just spaces of empty
							if(!((JTextField) arg0.getSource()).getText().isEmpty() && !((JTextField) arg0.getSource()).getText().trim().isEmpty()) {
								if(arg0.getKeyCode() == KeyEvent.VK_ENTER) { 
						            String name  = (String) ((JTextField) arg0.getSource()).getText();
						            String[] combine = name.split(" ");
						            name = combine[0] + combine[1];
						            HighList hiscores = new HighList();
						            hiscores.addToList(name, clock.getTime(), difficulty);
						            hiscores.saveRecord();
						            answer.dispose();
						        }
							}
						}

						@Override
						public void keyReleased(KeyEvent arg0) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void keyTyped(KeyEvent arg0) {
							// TODO Auto-generated method stub
							
						}
						
					});
					gbc.gridx = 0;
					gbc.gridy = 4;
					gbc.gridwidth = 2;
					gbc.ipady = 10;
					gbc.fill = GridBagConstraints.HORIZONTAL;
					panel.add(name, gbc);
					
					answer.setSize(350, 150);
				} else {
					answer.setTitle("Fail :(");
					JLabel fail = new JLabel("Board is not solved. Try again!");
					fail.setFont(new Font("Arial", Font.BOLD, 17));
					answer.setSize(300, 80);
					panel.add(fail);
				}
				answer.add(panel);
		    }
		});
        buttons.add(Solve, gbc);

		JButton Solution = new JButton("Solution");
		Solution.setFont(new Font("Arial", Font.BOLD, 15));
		gbc.weightx = 0.5;
		gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.ipady = 15;
        gbc.fill = GridBagConstraints.HORIZONTAL;		
        Solution.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				if (currentSolution!=null) {
					currentSolution.dispose();
				}
				currentSolution = new SolutionGUI(sudokuBoard.getSolution());

		    }
		});
        buttons.add(Solution, gbc);

		JButton Save = new JButton("Save");
		Save.setFont(new Font("Arial", Font.BOLD, 15));
		gbc.weightx = 0.5;
		gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        gbc.ipady = 15;
        gbc.fill = GridBagConstraints.HORIZONTAL;		
        Save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				try {
					sudokuBoard.save(clock.getTime(), hints);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});
		buttons.add(Save, gbc);

		JButton Back = new JButton("Back");
		Back.setFont(new Font("Arial", Font.BOLD, 15));
		gbc.weightx = 0.5;
		gbc.gridx = 2;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        gbc.ipady = 15;
        gbc.fill = GridBagConstraints.HORIZONTAL;		
        Back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				try {
					sudokuBoard.save(clock.getTime(), hints);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				dispose();
				menu.setVisible(true);
		    }
		});
        buttons.add(Back, gbc);

		return buttons;
	}

}
