package TEST.User_ProjectTest;

import database.models.Project;
import database.models.UserProject;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

// TESTING COLLECTING OF PROJECTS OF THE USER WHO IS LOGGED IN
public class ProjectListTest {

    @Test
    public void valid_getting_project_list_test(){
        int user_id = 3; // existing user ID
        List<Project> p = UserProject.getProjectListByUserId(user_id);
        assertNotNull(p);
    }

    @Test
    public void invalid_getting_project_list_test(){
        int user_id = 90219837; // unexisting user ID
        List<Project> p = UserProject.getProjectListByUserId(user_id);
        assertNull(p);
    }
}
