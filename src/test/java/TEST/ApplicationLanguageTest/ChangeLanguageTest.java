package TEST.ApplicationLanguageTest;


import auth.Authentication;
import controllers.AppLanguageController;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// Tests language changing of the app
public class ChangeLanguageTest {
    @Test
    public void invalid_changeLanTest() {
        // Japaneese doesn't exist in app's possible languages !
        boolean state = AppLanguageController.ChangeLanguage("Japaneese");
        assertFalse(state);

    }

    @Test
    public void valid_changeLanTest(){
        // Languages must be one of these English , Deutsch , Spanish or Turkish
        boolean state = AppLanguageController.ChangeLanguage("English");
        assertTrue(state);
    }

}
