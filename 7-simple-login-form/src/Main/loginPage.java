package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class loginPage implements ActionListener {

    HashMap<String,String> logininfo = new HashMap<String,String>();
    JFrame frame = new JFrame("login page");
    JButton loginButton = new JButton("login");
    JButton resetButton = new JButton("reset");
    JTextField userIdField = new JTextField();
    JPasswordField userPassField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID: ");
    JLabel userPassLabel = new JLabel("userPass: ");
    JLabel messageLabel = new JLabel();

    public loginPage(HashMap<String,String> loginInfoOriginal) {
        logininfo = loginInfoOriginal;

        userIDLabel.setBounds(50,100,75,25);
        userPassLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userIdField.setBounds(125,100,200,25);
        userPassField.setBounds(125,150,200,25);

        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225,200,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(userIdField);
        frame.add(userPassField);
        frame.add(messageLabel);
        frame.add(userIDLabel);
        frame.add(userPassLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setResizable(false);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            userIdField.setText("");
            userPassField.setText("");
        }
        if (e.getSource() == loginButton) {
            String userID = userIdField.getText();
            String password = String.valueOf(userPassField.getPassword());
            if (logininfo.containsKey(userID)) {
                if (logininfo.get(userID).equals(password)) {
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("login successful");
                    frame.dispose();
                    welcomPage welcompage = new welcomPage(userID);
                }
                else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("wrong password");
                }
            }
            else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("username not found");
            }
        }
    }
}
