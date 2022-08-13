import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame(SETTINGS.TITLE);
        frame.setSize(SETTINGS.WIDTH,SETTINGS.HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(SETTINGS.ALWAYS_ON_TOP);
        frame.setResizable(SETTINGS.RESIZABLE);
        frame.setLayout(null);
        frame.setMinimumSize(new Dimension(SETTINGS.MINIMUM_WIDTH + 30,SETTINGS.MINIMUM_HEIGHT + 30));
        frame.getContentPane().setBackground(new Color(0x5e327d));


        loginPanel panel = new loginPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(0xa599ad));

        panel.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.removeAll();
            }
        });

        panel.signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("sing in");
            }
        });





        JLabel titlePanel = new JLabel("_"+SETTINGS.APP_NAME+"_", SwingConstants.CENTER);
        titlePanel.setFont(new Font("ubuntu mono", Font.BOLD, 25));
        titlePanel.setBackground(new Color(0xa599ad));

        panel.add(titlePanel);
        frame.add(panel);
        frame.setVisible(true);


        frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent evt) {
                Component c = (Component)evt.getSource();
                if ( c == frame) {
                    panel.setBounds(frame.getWidth()/2 - SETTINGS.MINIMUM_WIDTH/2,
                                    frame.getHeight()/2 - SETTINGS.MINIMUM_HEIGHT/2,
                                    SETTINGS.MINIMUM_WIDTH ,
                                    SETTINGS.MINIMUM_HEIGHT);
                }
                titlePanel.setBounds(20,5,panel.getWidth()-40,50);
            }
        });
    }
}
