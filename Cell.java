import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Cell extends JLabel {
  
	private static final long serialVersionUID = 1L;
	private boolean editable;

	public Cell() {
		this.editable = true;
		setHorizontalAlignment(JTextField.CENTER);
		setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		setPreferredSize(new Dimension(40, 40));
		setFont(new Font("Lucida Console", Font.BOLD, 18));
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setOpaque(true);
	}
	
	public void setEditable(boolean status) {
		editable = status;
	}
	
	public boolean getEditable() {
		return editable;
	}
}
