package TEST.NonFunctionalRequirementsTest;

import database.models.FunctionalRequirements;
import database.models.NonFunctionalRequirements;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// TEST OF A VALID AND INVALID CREATION  OF NON-FUNCTIONAL REQUIREMENTS
public class CreateNonFunctionalRequirementsTest {

    @Test
    public void invalid_createNonFunc_test(){
        // unexisting project ID we are sending...
        int projectid = 99999;
        String body = "A!^^bsodfujab   dsoufıba";
        // trying to create non-func req. in unexisting project
        boolean state = NonFunctionalRequirements.createNonFuncReq(projectid,body);
        assertFalse(state);

    }

    @Test
    public void valid_createNonFunc_test(){
        // existing project ID we are sending...
        int projectid = 1;
        String body = "Test Body";
        // trying to create non-func req. in existing project
        boolean state = NonFunctionalRequirements.createNonFuncReq(projectid,body);
        assertTrue(state);
    }
}
