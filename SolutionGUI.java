import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JPanel;


public class SolutionGUI extends JPanel {
	private static final long serialVersionUID = 1L;
	Cell[][] board;
	
	public SolutionGUI() {
		board = new Cell[9][9];		
		JPanel squares = createSquares();
		add(squares);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width / 2 - 175), (d.height / 2 - 275));
		setVisible(true);
	}

	public JPanel createSquares() {
		JPanel squares = new JPanel();
		squares.setLayout(new GridLayout(9, 9, 1, 1));
		
		for(int col = 0 ; col < 9; col++) {
			for(int row = 0; row < 9; row++) {
				board[col][row] = new Cell(col, row);
				squares.add(board[col][row]);	
			}
		}
		return squares;
	}
}