import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Panel extends JPanel implements ActionListener{

    
    static final double PI = 3.141592653589793;
    static final int DELAY = 1;
    static final int Death_Line_Y = 700;
    static final int Max_Balls = 100;
    static final int Ball_Velocity = 10;
    static final int Ball_size = 20;
    static final int yPosition = 650;
    static final int breaker_height = 30;
    
    int breaker_width = 200;
    int Position = 500;
    int Velocity = 10;
    int number_of_balls = 0;
    int[] xBall = new int[Max_Balls];
    int[] yBall = new int[Max_Balls];
    double[] angle = new double[Max_Balls];
    boolean running = false;
    boolean moving = false;
    Timer timer;
    Random random = new Random();

    static final int LEVELS_NUMBER = 1;
    static final int brick_width = 90;
    static final int brick_height = 30;
    
    
    

    Panel() {
        this.setBounds(0,Game.SCORE_PANEL_HEIGHT,Game.WIDTH,Game.HEIGHT-Game.SCORE_PANEL_HEIGHT);
        this.setBackground(Color.blue);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame() {
        running = true;
        timer = new Timer(DELAY,this);
        newBall();
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
            //this will draw the map
            g.setColor(Color.black);

            //this will draw the breaker
            g.fillRect(Position, yPosition, breaker_width, breaker_height);

            //this will draw the line of death
            g.setColor(Color.white);
            g.drawLine(0, Death_Line_Y, Game.WIDTH, Death_Line_Y);

            //this does nothing but surround the breaker
            g.fillRect(Position, yPosition, breaker_width, 5);
            //g.fillRect(Position+breaker_width-5, yPosition, 5, 5);

            //this will draw the map
            int x = 30;
            int y = 0;
            for (int i = 0; i < 96; i++) {
                g.setColor(Color.red);
                g.fillRect(x, y, brick_width, brick_height);
                g.setColor(Color.white);
                g.drawRect(x, y, simpleBrick.width, simpleBrick.height);                
                x = x + simpleBrick.width+5;
                if (x >= Game.WIDTH-100) {
                    y = y + simpleBrick.height+5;
                    x = 30;
                }
            }

            //this will draw balls
            for (int i = 0; i < number_of_balls; i++) {
                g.fillOval(xBall[i], yBall[i], Ball_size, Ball_size);
            }
        }
        else {

        };
    }

    private void buildMap(int i) {
    }

    public void move() {
        if (moving) {
            Position = Position + Velocity;
        }
    }

    public void newBall() {
        if (number_of_balls == 0) {
            xBall[0] = Position + (breaker_width/2);
            yBall[0] = yPosition - 10;
            do {
                angle[0] = (random.nextDouble()+random.nextInt(313))/100;
            } while (angle[0] == 0);
            number_of_balls = 1;
        }
    }

    public void ball_move() {
        for (int i = 0; i < number_of_balls; i++) {
            xBall[i] = (int)Math.round(Ball_Velocity * Math.cos(-angle[i]) + xBall[i]);
            yBall[i] = (int)Math.round(Ball_Velocity * Math.sin(-angle[i]) + yBall[i]);
        }
    }

    public void ball_check(){
        for (int i = 0; i < number_of_balls; i++) {
            //--------Left------------
            if ((xBall[i] <= 0) && ((angle[i] < PI) && (angle[i] > PI/2))) {
                angle[i] = PI - angle[i];
            }
            if ((xBall[i] <= 0) && ((angle[i] > PI) && (angle[i] < PI*1.5))) {
                angle[i] = 3*PI - angle[i];
            }
            if ((xBall[i] <= 0) && (angle[i] == PI)) {
                angle[i] = 0;
            }
        //----------Right----------
            if ((xBall[i] >= Game.WIDTH) && ((angle[i] < PI/2) && (angle[i] > 0))) {
                angle[i] = PI - angle[i];
            }
            if ((xBall[i] >= Game.WIDTH) && (angle[i] > PI*1.5)) {
                angle[i] = 3*PI - angle[i];
            }
            if ((xBall[i] >= Game.WIDTH) && (angle[i] == 0)) {
                angle[i] = PI;
            }
        //-------Top-------------
            if ((yBall[i] <= 0) && ((angle[i] > PI/2) && (angle[i] < PI))) {
                angle[i] = 2*PI - angle[i];
            }
            if ((yBall[i] <= 0) && ((angle[i] > 0) && (angle[i] < PI/2))) {
                angle[i] = 2*PI - angle[i];
            }
            if ((yBall[i] <= 0) && (angle[i] == PI/2)) {
                angle[i] = PI*1.5;
            }
        //--------Botton-----------
            if ((yBall[i] >= 750) && ((angle[i] > PI) && (angle[i] < PI*1.5))) {
                angle[i] = 2*PI - angle[i];
            }
            if ((yBall[i] >= 750) && (angle[i] > PI*1.5)) {
                angle[i] = 2*PI - angle[i];
            }
            if ((yBall[i] >= 750) && (angle[i] == PI*1.5)) {
                angle[i] = PI/2;
            }
        //---------if the ball touches the bar----------yalla 7abibi
            if ((yBall[i] >= yPosition && yBall[i] <= yPosition+breaker_height) && (xBall[i] < Position + breaker_width) && (xBall[i] > Position)) {
                if (moving) {
                    if (Velocity > 0) {
                        angle[i] = PI + PI/4;
                    }
                    else {
                        angle[i] = PI/4;
                    }
                }
                else {
                    if (angle[i] == PI*1.5) {
                        angle[i] = PI/2;
                    }
                    if (angle[i] > PI*1.5) {
                        angle[i] = 2*PI - angle[i];
                    }
                    if ((angle[i] > PI) && (angle[i] < PI*1.5)) {
                        angle[i] = 2*PI - angle[i];
                    }
                }
            }
        //---------------Death line------------------
            if (yBall[i] >= Death_Line_Y) {
                deleteBall(i);
            }
        }
    }

    
    public void deleteBall(int x) {
        number_of_balls--;
        for (int i = x; i < number_of_balls; i++) {
            xBall[i] = xBall[i+1];
            yBall[i] = yBall[i+1];
            angle[i] = angle[i+1];
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            buildMap(1);
            ball_move();
            move();
            ball_check();
        }
        repaint();
        
    }

    public class MyKeyAdapter extends KeyAdapter  {
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT,KeyEvent.VK_Q:
                    moving = true;
                    Velocity = -Math.abs(Velocity);
                    break;
                case KeyEvent.VK_RIGHT,KeyEvent.VK_D:
                    moving = true;
                    Velocity = Math.abs(Velocity);
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT,KeyEvent.VK_Q:
                    moving = false;
                    break;
                case KeyEvent.VK_RIGHT,KeyEvent.VK_D:
                    moving = false;
                    break;
            }
        }
    }
    
}
