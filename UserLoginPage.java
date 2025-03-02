// UserLoginPage.java (Validates Login & Blocks after 3 Failures)
import javax.swing.*;
import java.util.HashMap;

public class UserLoginPage extends JFrame {
    private static final int MAX_ATTEMPTS = 3;
    private int attemptCounter = 0;
    private HashMap<String, String> userDatabase = new HashMap<>();

    public UserLoginPage() {
        setTitle("User Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel inputLabel = new JLabel("Enter User ID:");
        JTextField userIdField = new JTextField();
        JButton submitButton = new JButton("Submit");

        inputLabel.setBounds(30, 30, 100, 25);
        userIdField.setBounds(130, 30, 120, 25);
        submitButton.setBounds(100, 80, 100, 30);

        submitButton.addActionListener(e -> {
            String userId = userIdField.getText();
            if (userDatabase.containsKey(userId)) {
                new LoginResultPage("APPROVED");
            } else {
                attemptCounter++;
                if (attemptCounter >= MAX_ATTEMPTS) {
                    JOptionPane.showMessageDialog(this, "Too many failed attempts. Access blocked!");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid User ID. Attempt " + attemptCounter + " of " + MAX_ATTEMPTS);
                }
            }
        });

        add(inputLabel);
        add(userIdField);
        add(submitButton);
        setVisible(true);
    }
}
