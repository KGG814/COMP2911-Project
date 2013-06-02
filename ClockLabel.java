import java.awt.EventQueue;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;


public class ClockLabel extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int time;
	private Timer timer  = new Timer();
	ClockLabel (int time) {
		this.time = time;
		timer.schedule(new ClockTask(this), 0, 1000);
	}

	public int getTime () {
		return time;
	}
	
	private class ClockTask extends TimerTask {

		JLabel timerLabel;
		ClockTask (JLabel timerLabel) {
			this.timerLabel = timerLabel;
		}
		public void run() {
			EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                	timerLabel.setFont(new Font("Arial", Font.BOLD, 17));
                    timerLabel.setText("Time: " + String.valueOf(time++));
                }
            });
		}

	}

}
