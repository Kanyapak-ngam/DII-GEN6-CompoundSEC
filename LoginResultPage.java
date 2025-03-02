
// LoginResultPage.java
import javax.swing.*;

public class LoginResultPage extends JFrame {
    public LoginResultPage(String status) {
        setTitle("Login Result");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel statusLabel = new JLabel(status);
        statusLabel.setBounds(100, 50, 150, 30);

        add(statusLabel);
        setVisible(true);
    }
}
