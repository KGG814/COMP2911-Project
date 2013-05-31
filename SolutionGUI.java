import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class SolutionGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private BoardGUI solutionBoard;
	private SudokuBoard solution;

	public SolutionGUI(SudokuBoard solution) {
		JPanel panel = new JPanel();
		//panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		solutionBoard = new BoardGUI(solution);
		panel.add(solutionBoard);
		add(panel);	
		//Set JFrame Properties
		setLayout(new FlowLayout(FlowLayout.CENTER));
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
		this.solution = solution;
		pack();
		setResizable(false);
		setVisible(true);
	}

	public void populateBoard () {
		for (int col = 0; col<9; col++) {
			for (int row = 0; row<9; row++){
				//want to out
				String number = Integer.toString(solution.getNumber(col, row));
				solutionBoard.board[col][row].setText(number);
			}
		}
	}
}
