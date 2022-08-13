import java.awt.*;
import java.util.*;

public class Bell extends Rectangle {
    
    Random random;
    int xVelocity;
    int yVelocity;
    int inisialSpeed = 3;
    

    Bell(int x, int y, int width, int height){
        super(x,y,width,height);
        random = new Random();
        int randomXDirection = random.nextInt(2);
        if (randomXDirection == 0) 
            randomXDirection--;
        set_X_direction(randomXDirection*inisialSpeed);

        int randomYDirection = random.nextInt(2);
        if (randomYDirection == 0) 
            randomYDirection--;
        set_Y_direction(randomYDirection*inisialSpeed);
    }
 
    public void set_X_direction(int randomXdirection) {
        xVelocity = randomXdirection;
    }
    public void set_Y_direction(int randomYdirection) {
        yVelocity = randomYdirection;
    }
    public void move() {
        x = x + xVelocity;
        y = y + yVelocity;
    }
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x, y, width, height);
    }
}
