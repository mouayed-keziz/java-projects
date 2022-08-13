package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class myPanel extends JPanel implements ActionListener {

    Timer timer;
    ImageIcon image = new ImageIcon("logo.png");
    int step = 1;
    int i = 0;
    double j = 0.01;
    boolean h = false;

    myPanel() {
        this.setBackground(Color.black);
        this.setBounds(0,0,1000,600);

        timer = new Timer(1, this);
        timer.start();
    }

    public int f(int x) {
        return (500-i)+(int)(Math.sin((x*j)+3000*j)*100);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D G = (Graphics2D) g;
        G.setStroke(new BasicStroke(2));
        G.setPaint(Color.BLACK);
        for (int x = 0; x <= 1000; x += step) {
            G.drawLine(x, 0, x, f(x)-i);
        }
        G.setPaint(Color.ORANGE);
        for (int x = 0; x <= 1000; x += step) {
            G.drawLine(x, f(x)-i, x, 1000);
        }
        if (h) {
            G.drawImage(image.getImage(),385,170,Color.ORANGE,null);
            h = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        i++;
        if (j > 0) j = j - 0.00003;
        if (i == 300) {
            timer.stop();
            System.out.println("timer is stopped");
            h = true;
        }
        repaint();
    }
}
