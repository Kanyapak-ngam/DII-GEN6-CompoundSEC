import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InputForm().setVisible(true));
    }
}

// GUI: Input Form
class InputForm extends JFrame {
    private JTextField floorField, roomField, personalIdField;

    public InputForm() {
        setTitle("Input Data");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 192, 203)); // Light Pink
        panel.setPreferredSize(new Dimension(450, 250));
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Labels & Input Fields
        JLabel floorLabel = new JLabel("FLOOR");
        floorField = new JTextField(10);
        JLabel roomLabel = new JLabel("ROOM");
        roomField = new JTextField(10);
        JLabel idLabel = new JLabel("Personal ID");
        personalIdField = new JTextField(10);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processInput();
            }
        });

        gbc.gridx = 0; gbc.gridy = 0; panel.add(floorLabel, gbc);
        gbc.gridx = 1; panel.add(floorField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; panel.add(roomLabel, gbc);
        gbc.gridx = 1; panel.add(roomField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; panel.add(idLabel, gbc);
        gbc.gridx = 1; panel.add(personalIdField, gbc);
        gbc.gridx = 1; gbc.gridy = 3; panel.add(submitButton, gbc);

        add(panel);
        setLocationRelativeTo(null);
    }

    private void processInput() {
        String floorInput = floorField.getText();
        String roomInput = roomField.getText();
        String personalId = personalIdField.getText();

        Floor floor;
        if (floorInput.equalsIgnoreCase("Low")) {
            floor = new LowFloor();
        } else if (floorInput.equalsIgnoreCase("Medium")) {
            floor = new MediumFloor();
        } else {
            floor = new HighFloor();
        }

        Room room = new BasicRoom();
        if (roomInput.equalsIgnoreCase("Deluxe")) {
            room = new DeluxeRoom(room);
        }

        IDCard user = new UserIDCard(personalId);  // Uses Bridge Pattern
        PasswordSingleton password = PasswordSingleton.getInstance();

        new UserCard(user, password, floor, room).setVisible(true);
        this.dispose();
    }
}
