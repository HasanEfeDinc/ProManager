package TEST;

import TEST.AuthenticationTest.LoginTest;
import database.MyProManager;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


// MAIN CLASS FOR OUT TESTS
public class TestRunner {

    public static void main(String[] args){
        MyProManager.CREATE_CONNECTION();


        Result result = JUnitCore.runClasses(TestSuite.class);

        for(Failure failure: result.getFailures()){
            System.out.println("FAILURE : "+failure.toString());
        }


        System.out.println(result.wasSuccessful());
    }
}
