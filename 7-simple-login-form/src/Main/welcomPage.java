package Main;

import javax.swing.*;
import java.awt.*;

public class welcomPage {

    JFrame frame = new JFrame("welcome");
    JLabel welcomLabel = new JLabel("hello");

    welcomPage(String username) {

        welcomLabel.setBounds(0,0,200,35);
        welcomLabel.setFont(new Font(null, Font.PLAIN,25));
        welcomLabel.setText("Hello " +username);

        frame.add(welcomLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setAlwaysOnTop(true);
        frame.setResizable(true);
        frame.setResizable(false);

        frame.setVisible(true);
    }
}
