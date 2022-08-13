package Main;

import World.world1;

import javax.swing.*;

public class gameFrame extends JFrame {

    //final int WIDTH = 1000;
    //final int HEIGHT = 600;
    boolean frameOnTop = true;
    boolean frameResizable = false;

    gameFrame() {

        world1 world = new world1();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setAlwaysOnTop(frameOnTop);
        this.setResizable(frameResizable);
        //this.setSize(WIDTH, HEIGHT);

        this.add(world);
        this.pack();
        this.setLocationRelativeTo(null);
        
        


        this.setVisible(true);
    }
}
