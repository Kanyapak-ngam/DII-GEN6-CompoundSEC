// SecureID.java (Data Hiding Example)
package models;

public class SecureID {
    private String fullID;

    public SecureID(String id) {
        this.fullID = id;
    }

    public String getMaskedID() {
        return "****-****-" + fullID.substring(fullID.length() - 4);
    }
}
