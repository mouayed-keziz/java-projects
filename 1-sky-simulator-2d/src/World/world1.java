package World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class world1 extends JPanel implements ActionListener {

    ImageIcon BACKGROUND = new ImageIcon("src/Resources/Images/background.jpg") ;
    final static int PANEL_WIDTH = 1000;
    final static int PANEL_HEIGHT = 600;
    final int numberOfClouds = 10000;
    Cloud[] clouds = new Cloud[numberOfClouds];
    Timer timer;

    public world1() {

        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));

        for (int i = 0 ; i < numberOfClouds ; i++) {
            clouds[i] = new Cloud();
        }

        timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {

        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(BACKGROUND.getImage(), 0, 0, null);

        for (int i = 0 ; i < numberOfClouds ; i++) {
            g2d.drawImage(Cloud.image, clouds[i].CLOUD_POSITION_X, clouds[i].CLOUD_POSITION_Y, null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0 ; i < numberOfClouds ; i++) {
            if (clouds[i].CLOUD_POSITION_X > PANEL_WIDTH + 300 || clouds[i].CLOUD_POSITION_X < -300) {
                clouds[i].CLOUD_X_VELOCITY = clouds[i].CLOUD_X_VELOCITY * (-1);
            }
            clouds[i].CLOUD_POSITION_X = clouds[i].CLOUD_POSITION_X + clouds[i].CLOUD_X_VELOCITY;
        }
        repaint();
    }
}


