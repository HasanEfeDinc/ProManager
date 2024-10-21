package TEST.FileUploadingTest;


import controllers.FileShareController;
import controllers.UploadFileController;
import database.MyProManager;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// Tests File uploading
public class FileUploadTest {
    @Test
    public void invalid_fileUploadTest(){
        // incorrect file type
        boolean state = UploadFileController.upload("newFile","png");
        assertFalse(state);

    }

    @Test
    public void valid_fileUploadTest(){
        // correct file type
        boolean state = UploadFileController.upload("newFile","txt");
        assertTrue(state);
    }

}
