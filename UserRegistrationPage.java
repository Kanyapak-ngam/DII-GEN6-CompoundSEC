// UserRegistrationPage.java (3rd Page) - Implements Decorator Pattern
import javax.swing.*;

public class UserRegistrationPage extends JFrame {
    private JTextField personalIdField;
    private PersonaIID personalID;

    public UserRegistrationPage() {
        setTitle("User Registration");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel floorLabel = new JLabel("Floor:");
        JComboBox<String> floorDropdown = new JComboBox<>(new String[]{"Low", "Medium", "High"});

        JLabel roomLabel = new JLabel("Room:");
        JComboBox<String> roomDropdown = new JComboBox<>();

        JLabel personalIdLabel = new JLabel("Personal ID:");
        personalIdField = new JTextField();

        JButton submitButton = new JButton("Submit");

        floorDropdown.addActionListener(e -> {
            roomDropdown.removeAllItems();
            String selectedFloor = (String) floorDropdown.getSelectedItem();
            if (selectedFloor.equals("Low")) {
                roomDropdown.addItem("Cleaning Room");
            } else if (selectedFloor.equals("Medium")) {
                roomDropdown.addItem("Regular Room");
            } else {
                roomDropdown.addItem("Deluxe Room");
            }
        });

        submitButton.addActionListener(e -> {
            String idInput = personalIdField.getText();
            if (idInput.length() < 4) {
                JOptionPane.showMessageDialog(this, "Invalid Personal ID. Must be at least 4 digits.");
            } else {
                personalID = new PersonaIID(idInput); // Encapsulation
                String password = PasswordSingleton.getInstance(personalID.getLast3Digits()); // Singleton

                JOptionPane.showMessageDialog(this, "User Registered!\nPersonal ID: " + personalID.getHiddenID() +
                        "\nPassword: " + password);

                new UserIDPage(password);
                dispose();
            }
        });

        floorLabel.setBounds(30, 20, 100, 25);
        floorDropdown.setBounds(150, 20, 150, 25);
        roomLabel.setBounds(30, 50, 100, 25);
        roomDropdown.setBounds(150, 50, 150, 25);
        personalIdLabel.setBounds(30, 80, 100, 25);
        personalIdField.setBounds(150, 80, 150, 25);
        submitButton.setBounds(100, 130, 100, 30);

        add(floorLabel);
        add(floorDropdown);
        add(roomLabel);
        add(roomDropdown);
        add(personalIdLabel);
        add(personalIdField);
        add(submitButton);

        setVisible(true);
    }
}
