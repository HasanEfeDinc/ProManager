package TEST.FileSharingTest;


import controllers.FileShareController;
import database.MyProManager;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// Tests File sharing
public class FileShareTest {
    @Test
    public void invalid_fileShareTest(){
        // My file doesn't exist in given possible files
        boolean state = FileShareController.share("myfile","yourfile","hisfile","herfile");
        assertFalse(state);

    }

    @Test
    public void valid_fileShareTest(){
        boolean state = FileShareController.share("myfile","myfile","yourfile","hisfile","herfile");
        assertTrue(state);
    }

}
