// NewUserPage.java (2nd Page)
import javax.swing.*;

public class NewUserPage extends JFrame {
    public NewUserPage() {
        setTitle("New User");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton newUserButton = new JButton("New User");
        JButton currentStatusButton = new JButton("Current Status");

        newUserButton.setBounds(80, 50, 140, 30);
        currentStatusButton.setBounds(80, 100, 140, 30);

        newUserButton.addActionListener(e -> new UserRegistrationPage());

        add(newUserButton);
        add(currentStatusButton);
        setVisible(true);
    }
}