import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class SolutionGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private BoardGUI solutionBoard;
	
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
		setTitle("Solution");
		pack();
		setSize(400, 425);
		setResizable(true);
		setVisible(true);
	}
}
