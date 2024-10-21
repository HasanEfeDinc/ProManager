package TEST.CurrentProjectTest;

import database.models.CurrentProject;
import database.models.FunctionalRequirements;
import database.models.NonFunctionalRequirements;
import database.models.Project;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

// TEST OF GETTING NON-FUNCTIONAL REQUIREMENTS OF SELECTED (CURRENT) PROJECT
public class GetNonFunctionalRequirementsTest {

    @Test
    public void getNonFunctionalRequirements_test(){
        // We send existing current project, in the main program cannot be sent wrong ID, so we check only current one.
        Project our_current = Project.getProjectById(2);
        CurrentProject.setCurrentProject(our_current);
        List<NonFunctionalRequirements> nonFunctionalRequirements = CurrentProject.getCurrentProjectNonFuncReqs();
        assertNotNull(nonFunctionalRequirements);

    }
}
