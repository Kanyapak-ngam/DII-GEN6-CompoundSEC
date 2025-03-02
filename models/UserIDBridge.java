// Bridge Pattern (Syncing Registration with ID Representation)
package models;

public interface UserIDBridge {
    void syncUserData(String userID);
}

class UserRegistration implements UserIDBridge {
    private String userID;

    public void registerUser(String id) {
        this.userID = id;
        System.out.println("User registered with ID: " + id);
    }

    @Override
    public void syncUserData(String userID) {
        this.userID = userID;
        System.out.println("User ID synced in registration: " + userID);
    }
}

class UserIDCardDisplay implements UserIDBridge {
    private String displayedID;

    @Override
    public void syncUserData(String userID) {
        this.displayedID = userID;
        System.out.println("User ID displayed on card: " + userID);
    }
}

