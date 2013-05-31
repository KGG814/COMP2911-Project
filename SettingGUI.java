import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SettingGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private int difficulty;
    
    public SettingGUI() {

    	JPanel butt = buttons();
    	add(butt);
    	this.difficulty = 1;
    	
		setLayout(new FlowLayout(FlowLayout.CENTER));
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
		pack();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width / 2 - 275), (d.height / 2 - 275));
		setResizable(true);
		setVisible(true);
    }

    public JPanel buttons() {
        JPanel button = new JPanel();
        button.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        
        JLabel diff = new JLabel("Difficulty");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        button.add(diff, gbc);
        
        JButton one = new JButton("1");
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        button.add(one, gbc);
        one.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                difficulty = 1;
            }
        });
        
        JButton two = new JButton("2");
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        two.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                difficulty = 2;
            }
        });
        button.add(two, gbc);
        
        JButton three = new JButton("3");
        gbc.gridx = 6;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        three.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                difficulty = 3;
            }
        });
        button.add(three, gbc);
        
        JButton four = new JButton("4");
        gbc.gridx = 8;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        four.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                difficulty = 4;
            }
        });
        button.add(four, gbc);

        return button;
    }
    
    public int getDifficulty() {
    	return difficulty;
    }
}
