package outils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class outils {
    public static String getHashFromPassword(String clair)
    {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] encodedhash = digest.digest(clair.getBytes(StandardCharsets.UTF_8));
        Base64.Encoder enc = Base64.getEncoder();
        return enc.encodeToString(encodedhash);
    }
}
