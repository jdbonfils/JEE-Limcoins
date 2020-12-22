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

    public static String generateString(int length)
    {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; // Tu supprimes les lettres dont tu ne veux pas
        String pass = "";
        for(int x=0;x<length;x++)
        {
            int i = (int)Math.floor(Math.random() * 62); // Si tu supprimes des lettres tu diminues ce nb
            pass += chars.charAt(i);
        }
        System.out.println(pass);
        return pass;
    }
}
