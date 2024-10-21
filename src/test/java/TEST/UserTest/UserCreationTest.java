package TEST.UserTest;

import database.models.User;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

// USER CREATION TEST
public class UserCreationTest {

    @Test
    public void creation_test(){
        // we are trying to test user creation is successful or not
        String email = "test@gmail.com";
        String password = "password";
        boolean state = User.createUser(email,password);
        assertTrue(state);
    }

}
