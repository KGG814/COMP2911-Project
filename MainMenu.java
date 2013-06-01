import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame{  

	private static final long serialVersionUID = 1L;
	private SettingGUI settings;
	private HighGUI highscores;

    public MainMenu() {
    	
    	//Set JFrame Properties
    	setLayout(new FlowLayout(FlowLayout.CENTER));
    	JPanel but = buttons();
    	add(but);
    	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
        setSize(400,350);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width / 2 - 200), (d.height / 2 - 300));
		setResizable(true);
		setVisible(true);
    }
    
    public JPanel buttons() {
    	JPanel button = new JPanel();
    	button.setLayout(new GridBagLayout());
    	GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        
        ImageIcon titleImg = new ImageIcon("ui/title.png");
        JLabel title = new JLabel(titleImg);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        button.add(title,gbc);
        
        JButton continueGame = new JButton("Continue Game");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        continueGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				File f = new File("save.txt");
				if(f.exists()) {
					System.out.println("Continue");
					ContinueFileParser c = new ContinueFileParser(f);
					try {
						c.Parse();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					new SudokuGUI(c.getBoardArray(), c.getDifficulty(),c.getEditableArray());
					dispose();
				} else {
					//Do nothing
				}
		    }
		});
        button.add(continueGame,gbc);

        JButton newGame = new JButton("New Game");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        newGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				if(settings == null) {
					new SudokuGUI(1);
				} else {
					new SudokuGUI(settings.getDifficulty());
					settings.dispose();
					if(highscores != null) {
						highscores.dispose();
					}
				}
				dispose();
		    }
		});
        button.add(newGame,gbc);

        JButton setting = new JButton("Setting");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;      
        setting.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				if (settings!=null) {
					settings.dispose();
				}
				settings = new SettingGUI();

		    }
		});
        button.add(setting,gbc);

        JButton hiscore = new JButton("High Score");
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        hiscore.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) {
				if (highscores!=null) {
					highscores.dispose();
				}
				highscores = new HighGUI();

		    }
		});
        button.add(hiscore,gbc);
        
    	return button;
    }
}  
