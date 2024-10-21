package TEST.EncryptionTest;

import database.MyProManager;
import encryption.SHA_256_Encryption;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class StringEncryptionTest {
    @Test
    public void encryptionTest(){
        // We test whether encrypted string can be encrypted
        String test_password = "MyPassword";
        SHA_256_Encryption.getSHA(test_password);
        String encryptedString = SHA_256_Encryption.toHexString();
        assertNotNull(encryptedString);
    }
}
