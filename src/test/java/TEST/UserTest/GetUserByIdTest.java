package TEST.UserTest;

import database.models.User;
import org.junit.Test;

import static org.junit.Assert.*;


// TESTING GETTING A USER BY ID
public class GetUserByIdTest {

    @Test
    public void valid_getUser_ById_test(){
        // trying to test retrieving user by existing id
        int id = 3;
        User user = User.getUserById(id);
        assertNotNull(user);
    }

    @Test
    public void invalid_getUser_ById_test(){
        // trying to test retrieving user by unexisting id
        int id = 3209384;
        User user = User.getUserById(id);
        assertNull(user);
    }

}
