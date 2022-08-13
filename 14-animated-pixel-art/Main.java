import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class ColouringPixels extends Canvas {

    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 407; // Additional pixels needed for the frame
    private static final int HEIGHT = 427; // Additional pixels needed for the frame


    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int r = 0; r <= 2; r++) {

        for(int y = 0; y < HEIGHT; y++) { 
            for(int x = 0; x < WIDTH; x++) { 
                if (x >= 1 && x <= 100 && y >= 1 && y <=100){
                    g.setColor(Color.WHITE);
                } else if (x >= 101 && x <= 200 && y >= 101 && y <=200){
                    g.setColor(Color.RED);
                } else if (x >= 201 && x <= 300 && y >= 201 && y <=300){
                    g.setColor(Color.WHITE);
                } else if (x >= 301 && x <= 399 && y >= 301 && y <=400){
                    g.setColor(Color.RED);
                } else              
                {
                    g.setColor(Color.BLUE);
                }
                g.drawLine(x, y, x, y);
            }
        }
            for(int x = 0; x < HEIGHT; x++) {
                for(int y = 0; y < WIDTH; y++) {
                    if (x >= 1 && x <= 100 && y >= 1 && y <=100){
                        g.setColor(Color.RED);
                    } else if (x >= 101 && x <= 200 && y >= 101 && y <=200){
                        g.setColor(Color.WHITE);
                    } else if (x >= 201 && x <= 300 && y >= 201 && y <=300){
                        g.setColor(Color.RED);
                    } else if (x >= 301 && x <= 399 && y >= 301 && y <=400){
                        g.setColor(Color.WHITE);
                    } else              
                    {
                        g.setColor(Color.BLUE);
                    }
                    g.drawLine(x, y, x, y);
                }
            }
        }
        try {
            Thread.sleep(2000);             // Sleep for 2 seconds
            System.exit(0);             // Closed the program
        }catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ColouringPixels - Lesson 9");
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.add(new ColouringPixels());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}