package TEST.CurrentProjectTest;

import database.models.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

// TEST OF GETTING ALL THE TASKS
public class GetAllTasksTest {

    @Test
    public void valid_getAllTasks_test(){
        // We send existing current project, in the main program cannot be sent wrong ID, so we check only current one.
        Project our_current = Project.getProjectById(2);
        CurrentProject.setCurrentProject(our_current);
        List<Task> tasks = CurrentProject.getCurrentProjectAllTasks();
        assertNotNull(tasks);
    }

}
