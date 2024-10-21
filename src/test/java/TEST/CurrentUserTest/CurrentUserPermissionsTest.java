package TEST.CurrentUserTest;

import database.models.CurrentUser;
import database.models.User;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

// Tests Retrieving Currentuser's Permissions
public class CurrentUserPermissionsTest {

    @Test
    public void valid_getCurrentUserPermissions(){
        User currentUser = User.getUserById(2); // Valid user ID
        CurrentUser.setCurrentUser(currentUser);
        assertNotNull(CurrentUser.currentUserPermissons()); // expected it is not null
    }

    @Test
    public void invalid_getCurrentUserPermissions(){
        User currentUser = User.getUserById(2123123); // Invalid user ID
        CurrentUser.setCurrentUser(currentUser);
        assertNull(CurrentUser.currentUserPermissons()); // expected it is null
    }

}
