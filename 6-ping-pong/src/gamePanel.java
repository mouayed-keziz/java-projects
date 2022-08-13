import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class gamePanel extends JPanel implements Runnable{
    
    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.555555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Paddle paddle2;
    Bell ball;
    Score score;

    gamePanel() {
        newPaddles();
        newBell();
        score = new Score(GAME_WIDTH,GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();
    }
    public void paint(Graphics g) {
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }
    public void draw(Graphics g) {
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
    }
    public void run() {
        //game loop
        long lastTime = System.nanoTime();
        double amountOfticks = 60.0;
        double ns = 1000000000 / amountOfticks;
        double delta = 0;
        while (true) {
            long now = System.nanoTime();
            delta = delta + (now - lastTime)/ns;
            lastTime = now;
            if (delta >= 1) {
                move();
                ckeckCollision();
                repaint();
                delta--;
            }
        }
    }


    public void newBell() {
        //random = new Random();
        random = new Random();
        ball = new Bell(GAME_WIDTH/2 - BALL_DIAMETER/2,random.nextInt(GAME_HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);

    }
    public void newPaddles() {
        paddle1 = new Paddle(0,(GAME_HEIGHT/2) - (PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
        paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2) - (PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
    }
    public void move() {
        paddle1.move();
        paddle2.move();
        ball.move();
    }
    public void ckeckCollision() {
        //bounce ball off top and bbottom window edges
        if(ball.y <= 0)
            ball.set_Y_direction(-ball.yVelocity);
        if (ball.y >= GAME_HEIGHT-BALL_DIAMETER)
            ball.set_Y_direction(-ball.yVelocity);
        
        //bounce ball of paddles
        if (ball.intersects(paddle1)) {
            
            ball.xVelocity = -ball.xVelocity; 
            ball.xVelocity = ball.xVelocity + 1;
            if (ball.yVelocity > 0) ball.yVelocity = ball.yVelocity + 1;
            else ball.yVelocity = ball.yVelocity - 1;

            ball.set_X_direction(ball.xVelocity);
            ball.set_Y_direction(ball.yVelocity);
        }
        if (ball.intersects(paddle2)) {
            ball.xVelocity = -ball.xVelocity;
            ball.xVelocity = ball.xVelocity - 1;

            if (ball.yVelocity > 0) ball.yVelocity = ball.yVelocity + 1;
            else ball.yVelocity = ball.yVelocity - 1;

            ball.set_X_direction(ball.xVelocity);
            ball.set_Y_direction(ball.yVelocity);
        }
        
        
        //this stops paddles at window edges
        if (paddle1.y <= 0) 
            paddle1.y = 1;
        if (paddle1.y >= (GAME_HEIGHT-PADDLE_HEIGHT)) 
            paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;

        if (paddle2.y <= 0) 
            paddle2.y = 1;
        if (paddle2.y >= (GAME_HEIGHT-PADDLE_HEIGHT)) 
            paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;

        //giva a player 1 points and creats new paddles and ball
        if (ball.x <= 0) {
            score.player2++;
            newPaddles();
            newBell();
        }
        if (ball.x >= GAME_WIDTH - BALL_DIAMETER) {
            score.player1++;
            newPaddles();
            newBell();
        }
    }
    

    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
		}
    }
}
