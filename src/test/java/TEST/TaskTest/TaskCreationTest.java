package TEST.TaskTest;

import database.models.Task;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// TEST OF A TASK CREATION
public class TaskCreationTest {

    @Test
    public void valid_creation_test(){
        // we are trying to create a task in existing project
        int project_id = 3;
        int assigned_id = 2;
        String body = "Test Body";
        Date dateTime = new Date(2024-1900,4,1);
        boolean state = Task.createTask(project_id,assigned_id,body,dateTime);
        assertTrue(state);
    }

    @Test
    public void invalid_creation_test(){
        // we are trying to create a task in unexisting project
        int project_id = 398237224;
        int assigned_id = 232980340;
        String body = "Test Body";
        Date dateTime = new Date(2024-1900,5,1);
        boolean state = Task.createTask(project_id,assigned_id,body,dateTime);
        assertFalse(state);
    }
}
