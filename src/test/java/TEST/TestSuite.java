package TEST;

import TEST.ApplicationLanguageTest.ChangeLanguageTest;
import TEST.AuthenticationTest.LoginTest;
import TEST.CurrentProjectTest.GetAllTasksTest;
import TEST.CurrentProjectTest.GetCollaboratorsTest;
import TEST.CurrentProjectTest.GetFunctionalRequirementsTest;
import TEST.CurrentProjectTest.GetNonFunctionalRequirementsTest;
import TEST.CurrentUserTest.CurrentUserPermissionsTest;
import TEST.CurrentUserTest.GetCurrentUserTest;
import TEST.DatabaseConnectionTest.DatabaseConnectionTest;
import TEST.EncryptionTest.StringEncryptionTest;
import TEST.FileDownloadingTest.DownloadFileTest;
import TEST.FileSharingTest.FileShareTest;
import TEST.FileUploadingTest.FileUploadTest;
import TEST.FunctionalRequirementsTest.CreateFunctionalRequirementsTest;
import TEST.FunctionalRequirementsTest.RemoveFunctionalRequirementsTest;
import TEST.NonFunctionalRequirementsTest.CreateNonFunctionalRequirementsTest;
import TEST.NonFunctionalRequirementsTest.RemoveNonFunctionalRequirementsTest;
import TEST.ProjectTest.GetProjectByIdTest;
import TEST.ProjectTest.ProjectCreationTest;
import TEST.TaskTest.TaskCreationTest;
import TEST.TaskTest.TaskRemovalTest;
import TEST.UpcomingTaskTest.UpcomingTaskTest;
import TEST.UserTest.GetUserByEmailTest;
import TEST.UserTest.GetUserByIdTest;
import TEST.UserTest.UserCreationTest;
import TEST.UserTest.UserPermissionTest;
import TEST.User_ProjectTest.ProjectListTest;
import TEST.User_ProjectTest.UpdatePermissionTest;
import TEST.User_ProjectTest.UserProjectCreationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


// TEST SUITE CLASS TO HOLD ALL THE TESTS WE HAVE
@RunWith(Suite.class)
@Suite.SuiteClasses({
        // THERE IS 1 CLASS IN EACH ROW ! TEST CLASS COUNT : 30
        ChangeLanguageTest.class,
        LoginTest.class,
        GetAllTasksTest.class,
        GetCollaboratorsTest.class,
        GetFunctionalRequirementsTest.class,
        GetNonFunctionalRequirementsTest.class,
        GetCurrentUserTest.class,
        CurrentUserPermissionsTest.class,
        DatabaseConnectionTest.class,
        DownloadFileTest.class,
        FileShareTest.class,
        FileUploadTest.class,
        CreateFunctionalRequirementsTest.class,
        CreateNonFunctionalRequirementsTest.class,
        RemoveFunctionalRequirementsTest.class,
        RemoveNonFunctionalRequirementsTest.class,
        ProjectCreationTest.class,
        GetProjectByIdTest.class,
        GetUserByEmailTest.class,
        TaskCreationTest.class,
        TaskRemovalTest.class,
        ProjectListTest.class,
        UpdatePermissionTest.class,
        UserProjectCreationTest.class,
        GetUserByIdTest.class,
        UserCreationTest.class,
        GetUserByEmailTest.class,
        UserPermissionTest.class ,
        UpcomingTaskTest.class,
        StringEncryptionTest.class
})
public class TestSuite {

}
