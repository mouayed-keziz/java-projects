import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle {
    
    int id;
    int yVelocity;
    int speed = 10;

    Paddle(int x, int y, int paddleWidth, int paddleHeight, int id) {
        super(x,y,paddleWidth,paddleHeight);
        this.id = id;
    }

    public void keyPressed(KeyEvent e) {
        switch(id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_Z) {
                    set_Y_direction(-speed);
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    set_Y_direction(speed);
                }
                break;
            case 2: 
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    set_Y_direction(-speed);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    set_Y_direction(speed);
                }
                break;
        }
    }
    public void keyReleased(KeyEvent e) {
        switch(id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_Z) {
                    set_Y_direction(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    set_Y_direction(0);
                }
                break;
            case 2: 
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    set_Y_direction(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    set_Y_direction(0);
                }
                break;
        }
    }

    public void set_Y_direction(int Ydirection) {
        yVelocity = Ydirection;
    }
    public void move() {
        y = y + yVelocity;
    }
    public void draw(Graphics g) {
        if (id == 1) 
            g.setColor(Color.blue);
        else
            g.setColor(Color.red);
        g.fillRect(x, y, width, height);
        
    }
}
