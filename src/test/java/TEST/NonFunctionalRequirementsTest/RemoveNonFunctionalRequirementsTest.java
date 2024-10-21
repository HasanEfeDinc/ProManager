package TEST.NonFunctionalRequirementsTest;

import database.models.NonFunctionalRequirements;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// TEST OF A VALID AND INVALID REMOVAL FEATURE  OF NON-FUNCTIONAL REQUIREMENTS
public class RemoveNonFunctionalRequirementsTest {

    @Test
    public void invalid_removeNonFunc_test(){
        // unexisting project ID we are sending...
        int projectid = 190890908;
        String body = "A!^^bsodfujab   dsoufıba";
        // trying to remove non-func req. from unexisting project
        boolean state = NonFunctionalRequirements.removeNonFuncReq(projectid,body);
        assertFalse(state);

    }

    @Test
    public void valid_removeNonFunc_test(){
        // existing project ID we are sending...
        int projectid = 2;
        String body = "Test Body";
        // trying to remove non-func req. from existing project
        boolean state = NonFunctionalRequirements.removeNonFuncReq(projectid,body);
        assertTrue(state);
    }
}
