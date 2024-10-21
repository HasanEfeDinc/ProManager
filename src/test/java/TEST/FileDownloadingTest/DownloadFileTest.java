package TEST.FileDownloadingTest;


import controllers.DownloadFileController;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

// Tests File Downloading
public class DownloadFileTest {

    @Test
    public void download_file_test(){
        // we test file is downloadable
        boolean state = DownloadFileController.download();
        assertTrue(state);
    }

}
