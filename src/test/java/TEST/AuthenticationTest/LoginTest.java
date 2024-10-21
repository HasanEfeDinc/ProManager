package TEST.AuthenticationTest;


import auth.Authentication;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// HANDLES CORRECT AND FALSE INPUTS FOR LOGIN OF A USER
public class LoginTest{
    @Test
    public void invalid_login_test(){
        // Wrong Email and Password
        String email = "rand#mMa1l*com";
        String password = "asd987";
        boolean state = Authentication.Authenticate(email,password);
        assertFalse(state);

    }

    @Test
    public void valid_login_test(){
        // Valid Email And Password (Stored In Database)
        String email = "burak@gmail.com";
        String password = "1";
        boolean state = Authentication.Authenticate(email,password);
        assertTrue(state);
    }

}
