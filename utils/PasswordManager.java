// PasswordManager.java (Singleton Pattern)
package utils;

public class PasswordManager {
    private static PasswordManager instance;
    private String password;

    private PasswordManager() {}

    public static PasswordManager getInstance() {
        if (instance == null) {
            instance = new PasswordManager();
        }
        return instance;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public String getPassword() {
        return "@privateXXX"; // Masked password for security
    }
}
