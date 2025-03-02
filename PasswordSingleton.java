public class PasswordSingleton {
    private static PasswordSingleton instance;
    private String password;

    private PasswordSingleton(String last3Digits) {
        this.password = "@private" + last3Digits;
    }

    public static String getInstance(String last3Digits) {
        if (instance == null) {
            instance = new PasswordSingleton(last3Digits);
        }
        return instance.password;
    }
}
