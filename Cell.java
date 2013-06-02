import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Cell extends JLabel {

    private static final long serialVersionUID = 1L;
    private boolean editable;
    private final int col;
    private final int row;
    private final boolean onGrey;

    public Cell(int col, int row) {
        this.editable = true;
        this.col = col;
        this.row = row;
        this.onGrey = (col > 2 && col < 6 && row < 3)
            ||(row > 2 && row < 6 && col < 3)
            ||(col > 2 && col < 6 && row > 5)
            ||(row > 2 && row < 6 && col > 5);
        setHorizontalAlignment(JTextField.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        setPreferredSize(new Dimension(40, 40));
        setFont(new Font("Lucida Console", Font.BOLD, 18));
        setForeground(Color.BLACK);
        if(this.isGrey()) {
            setBackground(new Color(240,240,240));
        } else {
            setBackground(Color.WHITE);
        }
        setOpaque(true);
    }

    public void setEditable(boolean status) {
        editable = status;
        if(!status) {
            setForeground(Color.GRAY);
        }
    }

    public boolean getEditable() {
        return editable;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public boolean isGrey() {
        return onGrey;
    }
}
