import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HighGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    public HighGUI() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((d.width / 2 - 200), (d.height / 2 - 300));
        setResizable(true);
        setVisible(true);
        setSize(400,600);
        JPanel but = buttons();
        add(but,BorderLayout.SOUTH);
        drawList dl = new drawList();
        add(dl,BorderLayout.CENTER);
    }

    public JPanel buttons() {
        JPanel button = new JPanel();
        button.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        JButton toHome = new JButton("Main menu");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        toHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //add something
                new MainMenu();
                dispose();
            }
        });
        button.add(toHome,gbc);

        return button;
    }

    public static void main(String[] args) {
        new HighGUI();
    }
}
