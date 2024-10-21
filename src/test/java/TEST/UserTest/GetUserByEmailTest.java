package TEST.UserTest;

import database.models.User;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

// TESTING GETTING A USER BY Email
public class GetUserByEmailTest {

    @Test
    public void valid_getUser_ByEmail_test(){
        // trying to test retrieving user by existing email
        String email = "burak@gmail.com";
        User user = User.getUserByEmail(email);
        assertNotNull(user);
    }
    @Test
    public void invalid_getUser_ByEmail_test(){
        // trying to test retrieving user by unexisting email
        String email = "NoEmailLikeThis!!!*#";
        User user = User.getUserByEmail(email);
        assertNull(user);
    }
}
