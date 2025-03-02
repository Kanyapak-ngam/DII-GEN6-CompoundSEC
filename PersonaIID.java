public class PersonaIID {
    private String fullID;

    public PersonaIID(String fullID) {
        this.fullID = fullID;
    }

    public String getHiddenID() {
        return "****" + fullID.substring(fullID.length() - 4);
    }

    public String getLast3Digits() {
        return fullID.substring(fullID.length() - 3);
    }
}
