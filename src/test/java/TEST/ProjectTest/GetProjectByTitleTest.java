package TEST.ProjectTest;

import database.models.Project;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

// TEST OF A GETTING PROJECT BY ID
public class GetProjectByTitleTest {
    @Test
    public void invalid_getProject_ByTitle_Test(){
        // unexisting  project title
        String project_title  = "#$½§{[]}";
        Project p = Project.getProjectByTitle(project_title);
        assertNull(p);
    }

    @Test
    public void valid_getProject_ByTitle_Test(){
        // existing project title
        String project_title  = "Sample3";
        Project p = Project.getProjectByTitle(project_title);
        assertNotNull(p);
    }

}
