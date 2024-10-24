package encryption;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// SHA_256 ENCRYPTION CLASS FOR REGISTERED USERS' PASSWORDS
public class SHA_256_Encryption {

    private static byte[] hash = null;
    public static void getSHA(String input)
    {
        try{
            // Static getInstance method is called with hashing SHA
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // digest() method called
            // to calculate message digest of an input
            // and return array of byte
            hash =  md.digest(input.getBytes(StandardCharsets.UTF_8));
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static String toHexString()
    {
        try{
            // Convert byte array into signum representation
            BigInteger number = new BigInteger(1, hash);

            // Convert message digest into hex value
            StringBuilder hexString = new StringBuilder(number.toString(16));

            // Pad with leading zeros
            while (hexString.length() < 64)
            {
                hexString.insert(0, '0');
            }
            return hexString.toString();
        }catch (Exception e){
            return null;
        }
    }
}
