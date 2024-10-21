package TEST.UpcomingTaskTest;

import controllers.TaskController;
import database.models.Project;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

// TEST OF A PROJECT CREATION
public class UpcomingTaskTest {

    @Test
    public void upcoming_TasksTest(){
        // we are trying to test getting upcoming tasks
        Object state = TaskController.UpcomingTasks();
        assertNotNull(state);
    }
}
