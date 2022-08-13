import javax.swing.*;
import java.awt.*;
public class loginPanel extends JPanel {

    public JTextField usernameInput;
    public JLabel username, password, loginLabel;
    public JPasswordField passwordInput;
    public JButton loginButton;
    public JCheckBox showPassword;
    public JButton signInButton;

    public loginPanel() {
        loginLabel =new JLabel("LOGIN:");
        loginLabel.setFont(new Font("ubuntu mono", Font.BOLD, 25));
        loginLabel.setBounds(215,70,200,70);
        this.add(loginLabel);

        username = new JLabel("username : ");
        username.setFont(SETTINGS.DEFAULT_FONT);
        username.setBounds(30,150,100,40);
        this.add(username);

        password = new JLabel("password : ");
        password.setFont(SETTINGS.DEFAULT_FONT);
        password.setBounds(30,200,100,40);
        this.add(password);

        usernameInput = new JTextField();
        usernameInput.setBounds(140,150,330,40);
        this.add(usernameInput);

        passwordInput = new JPasswordField();
        passwordInput.setBounds(140,200,330,40);
        this.add(passwordInput);

        showPassword = new JCheckBox("show password");
        showPassword.setBounds(140,250,200,50);
        showPassword.setBackground(new Color(0xa599ad));
        showPassword.addActionListener(e -> {
            if (e.getSource() == showPassword) {
                if (showPassword.isSelected()) passwordInput.setEchoChar((char)0);
                else passwordInput.setEchoChar('*');
            }
        });
        this.add(showPassword);

        loginButton = new JButton("Login");
        loginButton.setFont(SETTINGS.DEFAULT_FONT);
        loginButton.setFocusable(false);
        loginButton.setBounds(150,350,200,40);
        this.add(loginButton);

        signInButton = new JButton("create a new account");
        signInButton.setBackground(new Color(0xa599ad));
        signInButton.setFont(new Font("ubuntu mono", Font.BOLD, 25));
        signInButton.setBounds(100,430,300,40);
        this.add(signInButton);
    }
}
