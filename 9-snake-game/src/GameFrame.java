import javax.swing.JFrame;

public class GameFrame extends JFrame {
 
    GameFrame() {
        
        this.add(new gamePanel());
        this.setTitle("Snake game demo by mouayed");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
