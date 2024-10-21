package TEST.UserTest;

import database.models.User;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

// TEST FOR USER PERMISSIONS
public class UserPermissionTest {

    @Test
    public void valid_user_permissions(){
        // trying to test retrieving user permissions by existing user id
        int user_id = 3;
        HashMap<String , Boolean> permissions= User.userPermissons(user_id);
        assertNotNull(permissions);
    }

    @Test
    public void invalid_user_permissions(){
        // trying to test retrieving user permissions by unexisting user id
        int user_id = 3012323;
        HashMap<String , Boolean> permissions= User.userPermissons(user_id);
        assertNull(permissions);
    }
}
