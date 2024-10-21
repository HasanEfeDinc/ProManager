package TEST.User_ProjectTest;

import database.models.UserProject;
import org.junit.Test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// TESTING CREATION OF AN INSTANCE OF USER_PROJECT CLASS (FOR A MYSQL SCHEMA)
public class UserProjectCreationTest {

    @Test
    public void valid_creation_test(){
        // trying to test creating user project  in existing project and with existing user
        int user_id = 3;
        int project_id = 2;
        boolean is_admin = false;
        boolean write_access = true;
        boolean read_access = true;
        boolean state = UserProject.createUserProject(user_id,project_id,is_admin,write_access,read_access);
        assertTrue(state);
    }


    @Test
    public void invalid_creation_test(){
        // trying to test creating user project  in unexisting project and with unexisting user
        int user_id = 10293;
        int project_id = 3828102;
        boolean is_admin = false;
        boolean write_access = true;
        boolean read_access = true;
        boolean state = UserProject.createUserProject(user_id,project_id,is_admin,write_access,read_access);
        assertFalse(state);
    }
}
