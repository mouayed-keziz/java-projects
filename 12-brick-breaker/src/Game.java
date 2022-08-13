import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 850;
    public static final int SCORE_PANEL_HEIGHT = 70;

    Game() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("brick breaker demo by mouayed");
        this.setSize(WIDTH,HEIGHT);
        this.setResizable(false);
        this.setLayout(null);
        this.setAlwaysOnTop(true);

        JPanel score_panel = new JPanel();
        score_panel.setBounds(0,0,WIDTH,SCORE_PANEL_HEIGHT);
        score_panel.setBackground(Color.black);
        score_panel.add(new JLabel("this game is not completed"));

        this.add(score_panel);
        this.add(new Panel());
        this.setVisible(true);
    }
}
