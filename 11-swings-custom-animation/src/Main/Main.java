package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("transition demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setLayout(null);

        /*JButton button = new JButton("TRANSITION!!");
        button.setFocusable(false);
        button.setBounds(430,250,120,50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("key pressed");
            }
        });*/

        myPanel panel = new myPanel();

        frame.add(panel);
        //frame.add(button);
        frame.setVisible(true);
    }



}