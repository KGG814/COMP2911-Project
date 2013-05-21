import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame{  

	private static final long serialVersionUID = 1L;

    public MainMenu() {
    	
    	JPanel but = buttons();
    	add(but);
    	
    	//Set JFrame Properties
    	setLayout(new FlowLayout(FlowLayout.CENTER));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width / 2 - 110), (d.height / 2 - 110));
		setResizable(true);
		setVisible(true);
    }
    
    public JPanel buttons() {
    	JPanel button = new JPanel();
    	button.setLayout(new GridBagLayout());
    	GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        JLabel title = new JLabel("Soduku Solver");
        gbc.gridx = 0;
        gbc.gridy = 0;
        button.add(title,gbc);

        JButton newGame = new JButton("New Game");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        newGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				//add something
				new SudokuGUI();
				dispose();
		    }
		});
        button.add(newGame,gbc);

        JButton setting = new JButton("Setting");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        button.add(setting,gbc);

        JButton hiscore = new JButton("High Score");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        button.add(hiscore,gbc);
        
    	return button;
    }
}  