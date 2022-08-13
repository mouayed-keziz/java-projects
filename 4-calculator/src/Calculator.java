import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.util.ArrayList;

//String.valueOf(numebrInDouble).split("\\.")[1].length()

public class Calculator extends JFrame implements ActionListener, MouseListener {
    
    boolean darkTheme = true;
    ImageIcon themeIcon1 = new ImageIcon("themeicon1.png");
    ImageIcon themeIcon2 = new ImageIcon("themeicon2.png");
    JLabel label, themeLabel ;
    JPanel panel1, panel2;
    JButton[] button = new JButton[20];
    JTextField textField1, textField2;
    double result = 0, current = 0 , previous = 0; 
    boolean inDecimal = false;
    String bord = "0";
    
   
    
    

    Calculator() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,650);
        this.setTitle("calculator demo by mouayed");
        this.setResizable(false);
        this.setLayout(null);

        panel1 = new JPanel();
        panel1.setBounds(0,0,400,20);

        panel2= new JPanel();
        panel2.setBounds(0,20,400,180);
        
        button[0] = setbutton("C");
        button[1] = setbutton("()");
        button[2] = setbutton("%");
        button[3] = setbutton("÷");
        button[4] = setbutton("7");
        button[5] = setbutton("8");
        button[6] = setbutton("9");
        button[7] = setbutton("x");
        button[8] = setbutton("4");
        button[9] = setbutton("5");
        button[10] = setbutton("6");
        button[11] = setbutton("-");
        button[12] = setbutton("1");
        button[13] = setbutton("2");
        button[14] = setbutton("3");
        button[15] = setbutton("+");
        button[16] = setbutton("+/-");
        button[17] = setbutton("0");
        button[18] = setbutton(",");
        button[19] = setbutton("=");
        
        label = new JLabel();
        label.setBounds(10,210,367,397);
        label.setOpaque(true);
        label.setLayout(new GridLayout(5,4,3,3));
        for (int i = 0 ; i < 20 ; i++) {
            label.add(button[i]);
            button[i].addActionListener(this);
        }
        
        themeLabel = new JLabel();
        themeLabel.setBounds(10,30,49,49);
        themeLabel.setOpaque(true);
        themeLabel.addMouseListener(this);
       
        textField1 = new JTextField();
        textField1.setFont(new Font("MV Boli", Font.PLAIN, 25));
        textField1.setBounds(20,100,348,80);
        textField1.setBorder(null);
        textField1.setEditable(false);
        textField1.setText(bord);

        textField2 = new JTextField();
        textField2.setFont(new Font("MV Boli", Font.PLAIN, 35));
        textField2.setBounds(150, 23, 220, 72);
        textField2.setBorder(null);
        textField2.setEditable(false);
       
        this.add(textField1);
        this.add(textField2);
        this.add(themeLabel);
        this.add(label);
        this.add(panel1);
        this.add(panel2);

        invertTheme();
        this.setAlwaysOnTop(true);
        this.setVisible(true);
    }
    

    public JButton setbutton (String txt) {
        JButton button = new JButton();
        button.setText(txt);
        button.setFont(new Font("MV Boli", Font.PLAIN, 34));
        button.setFocusable(false);
        button.setBorder(null);
        return button;
    }

    public void invertTheme() {

        if (darkTheme) {         
            for (int i = 0; i < 19; i++) {
                button[i].setBackground(new Color(0xcfd8dc));
                button[i].setForeground(Color.black);
            }
            button[19].setBackground(new Color(0x5eb8ff));
            button[19].setForeground(Color.black);
            this.getContentPane().setBackground(Color.white);
            panel1.setBackground(new Color(0x005b9f));
            panel2.setBackground(new Color(0x5eb8ff));
            label.setBackground(Color.white);
            textField1.setForeground(Color.black);
            textField1.setBackground(Color.white);
            textField1.setCaretColor(Color.white);
            textField2.setForeground(Color.black);
            textField2.setBackground(new Color(0x5eb8ff));
            textField2.setCaretColor(new Color(0x5eb8ff));

            themeLabel.setIcon(themeIcon2);
            darkTheme = false;
        }

        else {
            for (int i = 0; i < 19; i++) {
                button[i].setBackground(new Color(0x383237));
                button[i].setForeground(Color.white);
            }
            button[19].setBackground(new Color(0xffab00));
            button[19].setForeground(Color.white);
            this.getContentPane().setBackground(new Color(0x00000));
            panel1.setBackground(new Color(0xc67c00));
            panel2.setBackground(new Color(0xffab00));
            label.setBackground(new Color(0x00000));
            textField1.setForeground(Color.white);
            textField1.setBackground(new Color(0x00000));
            textField1.setCaretColor(new Color(0x00000)); 
            textField2.setForeground(Color.white);
            textField2.setBackground(new Color(0xffab00));
            textField2.setCaretColor(new Color(0xffab00));

            themeLabel.setIcon(themeIcon1);
            darkTheme = true;
        }
    }

    public double getCurr(JTextField field) {
        return Double.parseDouble(field.getText());
    }

    public double roundTwo(double x) {
        return (int)(Math.round(x * 1000000))/1000000.0;
    }
   
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button[17]) {
            if (Double.parseDouble(textField1.getText()) != 0) {
                textField1.setText(textField1.getText()+"0");
            }
        else {
            textField1.setText(textField1.getText()+"");
        }
        } 
        if (e.getSource() == button[12]) {    
            if (Double.parseDouble(textField1.getText()) == 0 && !inDecimal) {
                textField1.setText("1");
            }   
            else {
                textField1.setText(textField1.getText()+"1");
            }
        } 
        if (e.getSource() == button[13]) {
            if (Double.parseDouble(textField1.getText()) == 0 && !inDecimal) {
                textField1.setText("2");
            }   
            else {
                textField1.setText(textField1.getText()+"2");
            }
            
        } 
        if (e.getSource() == button[14]) {
            if (Double.parseDouble(textField1.getText()) == 0 && !inDecimal) {
                textField1.setText("3");
            }   
            else {
                textField1.setText(textField1.getText()+"3");
            }
            
            
        } 
        if (e.getSource() == button[8]) {
            if (Double.parseDouble(textField1.getText()) == 0 && !inDecimal) {
                textField1.setText("4");
            }   
            else {
                textField1.setText(textField1.getText()+"4");
            }
    
            
        } 
        if (e.getSource() == button[9]) {
            if (Double.parseDouble(textField1.getText()) == 0 && !inDecimal) {
                textField1.setText("5");
            }   
            else {
                textField1.setText(textField1.getText()+"5");
            }
            
            
        } 
        if (e.getSource() == button[10]) {
            if (Double.parseDouble(textField1.getText()) == 0 && !inDecimal) {
                textField1.setText("6");
            }   
            else {
                textField1.setText(textField1.getText()+"6");
            }
            
        } 
        if (e.getSource() == button[4]) {
            if (Double.parseDouble(textField1.getText()) == 0 && !inDecimal) {
                textField1.setText("7");
            }   
            else {
                textField1.setText(textField1.getText()+"7");
            }
            
        } 
        if (e.getSource() == button[5]) {
            if (Double.parseDouble(textField1.getText()) == 0 && !inDecimal) {
                textField1.setText("8");
            }   
            else {
                textField1.setText(textField1.getText()+"8");
            }
            
        } 
        if (e.getSource() == button[6]) {
            if (Double.parseDouble(textField1.getText()) == 0 && !inDecimal) {
                textField1.setText("9");
            }   
            else {
                textField1.setText(textField1.getText()+"9");
            }
            
        }
        if (e.getSource() == button[15]) {            
            if (textField2.getText().isEmpty()) {
                current = getCurr(textField1);
                current = roundTwo(current);
                textField2.setText(current+" +");
            }
            else if (textField2.getText().charAt(textField2.getText().length()-1) == '+') {
                current = current + getCurr(textField1);
                current = roundTwo(current);
                textField2.setText(current+" +");
            }
            else if (textField2.getText().charAt(textField2.getText().length()-1) == '-') {
                current = current - getCurr(textField1);
                current = roundTwo(current);
                textField2.setText(current+" +");
            }
            else if (textField2.getText().charAt(textField2.getText().length()-1) == '*') {
                current = current * getCurr(textField1);
                current = roundTwo(current);
                textField2.setText(current+" +");
            }
            else if (textField2.getText().charAt(textField2.getText().length()-1) == '/') {
                current = current / getCurr(textField1);
                current = roundTwo(current);
                textField2.setText(current+" +");
            }
            else {
                current = getCurr(textField2);
                current = roundTwo(current);
                textField2.setText(current+" +");

            }
            textField1.setText("0");
        } 
        if (e.getSource() == button[11]) {
            if (textField2.getText().isEmpty()) {
                current = getCurr(textField1);
                current = roundTwo(current);
                textField2.setText(current+" -");
            }
            else if (textField2.getText().charAt(textField2.getText().length()-1) == '+') {
                current = current + getCurr(textField1);
                current = roundTwo(current);
                textField2.setText(current+" -");
            }
            else if (textField2.getText().charAt(textField2.getText().length()-1) == '-') {
                current = current - getCurr(textField1);
                current = roundTwo(current);
                textField2.setText(current+" -");
            }
            else if (textField2.getText().charAt(textField2.getText().length()-1) == '*') {
                current = current * getCurr(textField1);
                current = roundTwo(current);
                textField2.setText(current+" -");
            }
            else if (textField2.getText().charAt(textField2.getText().length()-1) == '/') {
                current = current / getCurr(textField1);
                current = roundTwo(current);
                textField2.setText(current+" -");
            }
            else {
                current = getCurr(textField2);
                current = roundTwo(current);
                textField2.setText(current+" -");

            }
            textField1.setText("0");
            
        } 
        if (e.getSource() == button[7]) {
            if (textField2.getText().isEmpty()) {
                current = getCurr(textField1);
                current = roundTwo(current);
                textField2.setText(current+" *");
            }
            else if (textField2.getText().charAt(textField2.getText().length()-1) == '+') {
                current = current + getCurr(textField1);
                current = roundTwo(current);
                textField2.setText(current+" *");
            }
            else if (textField2.getText().charAt(textField2.getText().length()-1) == '-') {
                current = current - getCurr(textField1);
                textField2.setText(current+" *");
            }
            else if (textField2.getText().charAt(textField2.getText().length()-1) == '*') {
                current = current * getCurr(textField1);
                current = roundTwo(current);
                textField2.setText(current+" *");
            }
            else if (textField2.getText().charAt(textField2.getText().length()-1) == '/') {
                current = current / getCurr(textField1);
                current = roundTwo(current);
                textField2.setText(current+" *");
            }
            else {
                current = getCurr(textField2);
                current = roundTwo(current);
                textField2.setText(current+" *");

            }
            textField1.setText("0");
            
        } 
        if (e.getSource() == button[3]) {
            if (textField2.getText().isEmpty()) {
                current = getCurr(textField1);
                current = roundTwo(current);
                textField2.setText(current+" /");
            }
            else if (textField2.getText().charAt(textField2.getText().length()-1) == '+') {
                current = current + getCurr(textField1);
                current = roundTwo(current);
                textField2.setText(current+" /");
            }
            else if (textField2.getText().charAt(textField2.getText().length()-1) == '-') {
                current = current - getCurr(textField1);
                current = roundTwo(current);
                textField2.setText(current+" /");
            }
            else if (textField2.getText().charAt(textField2.getText().length()-1) == '*') {
                current = current * getCurr(textField1);
                current = roundTwo(current);
                textField2.setText(current+" /");
            }
            else if (textField2.getText().charAt(textField2.getText().length()-1) == '/') {
                current = current / getCurr(textField1);
                current = roundTwo(current);
                textField2.setText(current+" /");
            }
            else {
                current = getCurr(textField2);
                current = roundTwo(current);
                textField2.setText(current+" /");

            }
            textField1.setText("0");
            
        }
        if (e.getSource() == button[2]) {
            textField2.setText(textField1.getText()+"%");
            current = getCurr(textField1);
            textField1.setText("");
        }
        if (e.getSource() == button[18]) {
            textField1.setText(textField1.getText()+".");
            
        } 
        if (e.getSource() == button[16]) {
            if (textField1.getText().charAt(0) == '-') {
                textField1.setText(textField1.getText().replaceAll("-", ""));
            }
            else {
                textField1.setText("-"+textField1.getText());
            }            
        } 
        if (e.getSource() == button[1]) {
            textField1.setText(textField1.getText()+"(");
            
        } 
        if (e.getSource() == button[0]) {
            current = 0;
            textField1.setText("0");
            textField2.setText("");
        } 
        if (e.getSource() == button[19]) {       
            if (textField2.getText().isEmpty()) {
                textField2.setText("");
            }
            else if (textField2.getText().charAt(textField2.getText().length()-1) == '+') {
                current = current + getCurr(textField1);
                current = roundTwo(current);
                textField2.setText(current+"");
            }
            else if (textField2.getText().charAt(textField2.getText().length()-1) == '-') {
                current = current - getCurr(textField1);
                current = roundTwo(current);
                textField2.setText(current+"");
            }
            else if (textField2.getText().charAt(textField2.getText().length()-1) == '*') {
                current = current * getCurr(textField1);
                current = roundTwo(current);
                textField2.setText(current+"");
            }
            else if (textField2.getText().charAt(textField2.getText().length()-1) == '/') {
                current = current / getCurr(textField1);
                current = roundTwo(current);
                textField2.setText(current+"");
            }
            else {
                textField2.setText("");
            }
            textField1.setText("0");
            current = 0;
        } 
    }
    

    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        invertTheme();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}










