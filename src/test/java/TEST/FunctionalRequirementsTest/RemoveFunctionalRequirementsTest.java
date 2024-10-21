package TEST.FunctionalRequirementsTest;

import database.models.FunctionalRequirements;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// TEST OF A VALID AND INVALID REMOVAL FEATURE  OF FUNCTIONAL REQUIREMENTS
public class RemoveFunctionalRequirementsTest {

    @Test
    public void invalid_removeFunc_test(){
        int projectid = 99978;
        String body = "A!^^bsodf ba";
        // trying to remove func req. from unexisting project
        boolean state = FunctionalRequirements.removeFuncReq(projectid,body);
        assertFalse(state);

    }

    @Test
    public void valid_removeFunc_test(){
        int projectid = 1;
        String body = "Test Body";
        // trying to remove func req. from existing project
        boolean state = FunctionalRequirements.removeFuncReq(projectid,body);
        assertTrue(state);
    }
}
