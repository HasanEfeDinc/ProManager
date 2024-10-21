package TEST.TaskTest;

import database.models.Task;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


// TEST OF THE REMOVAL FEATURE OF THE TASKS
public class TaskRemovalTest {

    @Test
    public void valid_removalTest(){
        // we are trying to delete a task from existing project
        int project_id = 3;
        int assigned_id = 2;
        String body = "Test Body";
        boolean state = Task.removeTask(project_id,body,assigned_id);
        assertTrue(state);
    }

    @Test
    public void invalid_removalTest(){
        // we are trying to delete a task from unexisting project
        int project_id = 3123123;
        int assigned_id = 2123123;
        String body = "Test Body";
        boolean state = Task.removeTask(project_id,body,assigned_id);
        assertTrue(state);
    }
}
