import javax.swing.*;
import java.awt.*;

// Bridge Interface
interface IDCard {
    String getUserID();
}

// Concrete Implementor (Data Hiding Removed)
class UserIDCard implements IDCard {
    private String userID;

    public UserIDCard(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID; // Show actual user ID now
    }
}

// Singleton Pattern for Password
class PasswordSingleton {
    private static PasswordSingleton instance;
    private String password;
//กำหนดได้เฉพาะadmin
    private PasswordSingleton() {
        password = "Secret@123"; // Change this if needed
        if
    }

    public static PasswordSingleton getInstance() {
        if (instance == null) {
            instance = new PasswordSingleton();
        }
        return instance;
    }

    public String getPassword() {
        return password; // Show actual password now
    }
}

// Abstract class for Floor Representation
abstract class Floor {
    abstract String getFloorLevel();
}

class LowFloor extends Floor {
    public String getFloorLevel() {
        return "Low Floor";
    }
}

class MediumFloor extends Floor {
    public String getFloorLevel() {
        return "Medium Floor";
    }
}

class HighFloor extends Floor {
    public String getFloorLevel() {
        return "High Floor";
    }
}

// Room (Decorator Pattern)
interface Room {
    String getDescription();
}

class BasicRoom implements Room {
    public String getDescription() {
        return "Basic Room";
    }
}
class MeetingRoom implements Room{
    @Override
    public String getDescription() {
        return "Meeting Room";
    }
}
abstract class RoomDecorator implements Room {
    protected Room decoratedRoom;

    public RoomDecorator(Room room) {
        this.decoratedRoom = room;
    }

    public String getDescription() {
        return decoratedRoom.getDescription();
    }
}

class DeluxeRoom extends RoomDecorator {
    public DeluxeRoom(Room room) {
        super(room);
    }

    public String getDescription() {
        return super.getDescription() + " with Deluxe Features";
    }
}

// GUI: User Card (Displays User Information)
class UserCard extends JFrame {
    public UserCard(IDCard idCard, PasswordSingleton password, Floor floor, Room room) {
        setTitle("User ID Card");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(230, 250, 250));
        panel.setPreferredSize(new Dimension(350, 200));
        panel.setLayout(new GridBagLayout());

        JLabel floorLabel = new JLabel("Floor: " + floor.getFloorLevel());
        JLabel roomLabel = new JLabel("Room: " + room.getDescription());
        JLabel userIdLabel = new JLabel("USER ID: " + idCard.getUserID()); // Show real user ID
        JLabel passwordLabel = new JLabel("Password: " + password.getPassword()); // Show real password

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridy = 0; panel.add(floorLabel, gbc);
        gbc.gridy = 1; panel.add(roomLabel, gbc);
        gbc.gridy = 2; panel.add(userIdLabel, gbc);
        gbc.gridy = 3; panel.add(passwordLabel, gbc);

        add(panel);
        setLocationRelativeTo(null);
    }
}
