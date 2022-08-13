package Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener{

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JPanel panel;
    Font myfont = new Font("Ink Free",Font.PLAIN,30);
    double num1 = 0, num2 = 0 , result = 0;
    char operation;

    Main() {

        frame = new JFrame("calculator demo by mouayed");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        frame.setAlwaysOnTop(true);
        frame.setLocationRelativeTo(null);

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myfont);
        textField.setEditable(false);

        functionButtons[0] = new JButton("+");
        functionButtons[1] = new JButton("-");
        functionButtons[2] = new JButton("*");
        functionButtons[3] = new JButton("/");
        functionButtons[4] = new JButton("=");
        functionButtons[5] = new JButton(".");
        functionButtons[6] = new JButton("Del");
        functionButtons[7] = new JButton("Clr");
        functionButtons[8] = new JButton("neg");

        for (int i = 0; i < 9; i++) {
            functionButtons[i].setFont(myfont);
            functionButtons[i].setBackground(Color.lightGray);
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myfont);
            numberButtons[i].setBackground(Color.white);
            numberButtons[i].setFocusable(false);
        }
        functionButtons[6].setBounds(50,430,95,50);
        functionButtons[7].setBounds(150,430,95,50);
        functionButtons[8].setBounds(250,430,95,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        int x = -2;
        for (int i = 1; i < 10; i++) {
            panel.add(numberButtons[i]);
            if (x % 3 == 0) {
                panel.add(functionButtons[x/3]);
            }
            x++;
        }
        panel.add(functionButtons[5]);
        panel.add(numberButtons[0]);
        panel.add(functionButtons[4]);
        panel.add(functionButtons[3]);

        frame.add(textField);
        frame.add(panel);
        frame.add(functionButtons[6]);
        frame.add(functionButtons[7]);
        frame.add(functionButtons[8]);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0 ;i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == functionButtons[5]) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == functionButtons[0]) {
            num1 = Double.parseDouble(textField.getText());
            operation = '+';
            textField.setText("");
        }
        if (e.getSource() == functionButtons[1]) {
            num1 = Double.parseDouble(textField.getText());
            operation = '-';
            textField.setText("");
        }
        if (e.getSource() == functionButtons[2]) {
            num1 = Double.parseDouble(textField.getText());
            operation = '*';
            textField.setText("");
        }
        if (e.getSource() == functionButtons[3]) {
            num1 = Double.parseDouble(textField.getText());
            operation = '/';
            textField.setText("");
        }
        if (e.getSource() ==functionButtons[4]) {
            num2 = Double.parseDouble(textField.getText());
            switch (operation) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() ==functionButtons[7]) {
            textField.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
        }
        if (e.getSource() == functionButtons[6]) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < (string.length()-1); i++) {
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        if (e.getSource() == functionButtons[8]) {
            textField.setText(String.valueOf((-1)*Double.parseDouble(textField.getText())));
        }
    }
}
