package TEST.CurrentUserTest;

import database.models.CurrentUser;
import database.models.User;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

// Tests Current User Can Be Set And Get Succesfully

public class GetCurrentUserTest {

    @Test
    public void valid_getCurrentUser(){
        User currentUser = User.getUserById(2); // Valid user ID
        CurrentUser.setCurrentUser(currentUser);
        assertNotNull(CurrentUser.getCurrentUser()); // expected it is not null
    }

    @Test
    public void invalid_getCurrentUser(){
        User currentUser = User.getUserById(2123123); // Invalid user ID
        CurrentUser.setCurrentUser(currentUser);
        assertNull(CurrentUser.getCurrentUser()); // expected it is null
    }
}
