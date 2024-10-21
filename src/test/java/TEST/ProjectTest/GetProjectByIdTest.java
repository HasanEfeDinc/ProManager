package TEST.ProjectTest;

import database.models.Project;
import org.junit.Test;

import static org.junit.Assert.*;


// TEST OF A GETTING PROJECT BY ID
public class GetProjectByIdTest {


    @Test
    public void valid_getProject_ByID_Test(){
        // existing  project id
        int project_id = 2;
        Project p = Project.getProjectById(project_id);
        assertNotNull(p);
    }
    @Test
    public void invalid_getProject_ByID_Test(){
        // unexisting  project id
        int project_id = 202891;
        Project p = Project.getProjectById(project_id);
        assertNull(p);
    }

}
