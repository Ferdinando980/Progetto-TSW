package model.util;



import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {


    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email != null && email.matches(emailRegex);
    }


    public static boolean isValidPhone(String numeroTel) {
        String phoneRegex = "^[0-9]{3} [0-9]{3} [0-9]{4}$";
        return numeroTel != null && numeroTel.matches(phoneRegex);
    }


    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 6 && password.length() <= 15
                && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*")
                && password.matches(".*[0-9].*") && password.matches(".*[!@#$%^&*()].*");
    }


    public static boolean isValidUsername(String username) {
        return username != null && username.length() >= 6 && username.length() <= 12
                && username.matches("^[a-zA-Z0-9 ]+$");
    }


    public static String toHash(String password) {
        StringBuilder hashString = new StringBuilder();
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            for (byte b : hash) {
                hashString.append(String.format("%02x", b));
            }
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e);
        }
        return hashString.toString();
    }
}
