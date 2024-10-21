package TEST.FunctionalRequirementsTest;

import auth.Authentication;
import database.models.FunctionalRequirements;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// TEST OF A VALID AND INVALID CREATION  OF FUNCTIONAL REQUIREMENTS
public class CreateFunctionalRequirementsTest {

    @Test
    public void invalid_createFunc_test(){
        // unexisting project ID we are sending...
        int projectid = 99999;
        String body = "A!^^bsodfujab   dsoufıba";
        // trying to create func req. in unexisting project
        boolean state = FunctionalRequirements.createFuncReq(projectid,body);
        assertFalse(state);

    }

    @Test
    public void valid_createFunc_test(){
        // existing project ID we are sending...
        int projectid = 1;
        String body = "Test Body";
        // trying to create func req. in existing project
        boolean state = FunctionalRequirements.createFuncReq(projectid,body);
        assertTrue(state);
    }
}
