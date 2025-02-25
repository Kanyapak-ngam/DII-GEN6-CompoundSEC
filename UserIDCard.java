import javax.swing.*;
import java.awt.*;

class DataHiding {
    private String userID;

    public DataHiding(String userID) {
        this.userID = userID;
    }

    // Method to return a masked user ID
    public String getMaskedUserID() {
        return "******"; // Hides the actual user ID
    }
}

public class UserIDCard extends JFrame {
    public UserIDCard(DataHiding user) {
        setTitle("User ID Card");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        // Panel settings
        JPanel panel = new JPanel();
        panel.setBackground(new Color(230, 250, 250)); // Light blue background
        panel.setPreferredSize(new Dimension(350, 150));
        panel.setLayout(new GridBagLayout());

        // Labels
        JLabel userIdLabel = new JLabel("USER ID");
        userIdLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel maskedUserId = new JLabel(user.getMaskedUserID());
        maskedUserId.setFont(new Font("Arial", Font.BOLD, 24));

        // Add to panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(userIdLabel, gbc);

        gbc.gridy = 1;
        panel.add(maskedUserId, gbc);

        add(panel);
        setLocationRelativeTo(null); // Center the window
    }

    public static void main(String[] args) {
        DataHiding user = new DataHiding("123456"); // Encapsulated user data
        SwingUtilities.invokeLater(() -> new UserIDCard(user).setVisible(true));
    }
}


