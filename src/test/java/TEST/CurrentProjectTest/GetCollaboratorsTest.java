package TEST.CurrentProjectTest;

import database.models.CurrentProject;
import database.models.Project;
import database.models.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


// TEST OF GETTING COLLABRATORS OF SELECTED (CURRENT) PROJECT
public class GetCollaboratorsTest {


    @Test
    public void getCollaborators_test(){
        // We send existing current project, in the main program cannot be sent wrong ID, so we check only current one.
        Project our_current = Project.getProjectById(2);
        CurrentProject.setCurrentProject(our_current);
        List<User> collaborators = CurrentProject.getCollabrators();
        assertNotNull(collaborators);

    }

}
