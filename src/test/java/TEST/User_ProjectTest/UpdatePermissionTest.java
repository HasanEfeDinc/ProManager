package TEST.User_ProjectTest;

import database.models.UserProject;
import org.junit.Test;


import static org.junit.Assert.*;

// TESTING UPDATING USER PERMISSIONS IN THE MYSQL DATABASE
public class UpdatePermissionTest {

    @Test
    public void valid_update_permission_test(){
        // trying to test updating permissions in existing project and with existing user
        int user_id = 3;
        int project_id = 5;
        boolean write_access = true;
        boolean p = UserProject.updatePermission(user_id,project_id,"write_access",write_access);
        assertTrue(p);
    }

    @Test
    public void invalid_update_permission_test(){
        // trying to test updating permissions in unexisting project and with unexisting user
        int user_id = 90219837;
        int project_id = 50987;
        boolean write_access = true;
        boolean p = UserProject.updatePermission(user_id,project_id,"write_access",write_access);
        assertTrue(p);
    }
}
