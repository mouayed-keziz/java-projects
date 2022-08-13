import javax.swing.JFrame;
import java.awt.*;

public class gameFrame extends JFrame {
   
    gamePanel panel;
    
    gameFrame() {
        panel = new gamePanel();
        this.add(panel);
        this.setTitle("Pong Game demo by mouayed");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
