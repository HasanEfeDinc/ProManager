package TEST.ProjectTest;

import database.models.Project;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// TEST OF A PROJECT CREATION
public class ProjectCreationTest {

    @Test
    public void creation_test(){
        // we are trying to test whether we can exactly create a project
        boolean state = Project.createProject("New Test Project","Test purpose definition");
        assertTrue(state);
    }
}
