import java.awt.*;
import javax.swing.*;

public class drawList extends JPanel {
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        String t = new HighList().getMsg();
        int x = 20;
        int y = 20;
        for( String line : t.split("\n")) {
            g2.drawString(line,x,y);
            y += 20;
        }
    }
}
