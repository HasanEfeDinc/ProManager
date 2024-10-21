package TEST.DatabaseConnectionTest;


import controllers.AppLanguageController;
import database.MyProManager;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// Tests Database connection
public class DatabaseConnectionTest {
    @Test
    public void invalid_connectionTest(){
        // Invalid or unexist Connection inputs
        boolean state = MyProManager.CREATE_CONNECTION("host","username","password");
        assertFalse(state);

    }

    @Test
    public void valid_connectionTest(){
        // Existing Connection inputs (Defined in the method)
        boolean state = MyProManager.CREATE_CONNECTION();
        assertTrue(state);
    }

}
