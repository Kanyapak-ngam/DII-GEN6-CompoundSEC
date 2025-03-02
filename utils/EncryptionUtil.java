// EncryptionUtil.java (Time-Based Encryption for User Authentication)
package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalTime;

public class EncryptionUtil {
    public static String encrypt(String userID) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String salt = String.valueOf(LocalTime.now().getMinute());
            md.update((userID + salt).getBytes());
            byte[] digest = md.digest();

            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                hexString.append(Integer.toHexString(0xFF & b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Encryption failed", e);
        }
    }
}
