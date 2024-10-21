package app;

import database.MyProManager;
import database.models.CurrentUser;
import database.models.User;
import encryption.SHA_256_Encryption;
import javafx.application.Application;
import javafx.stage.Stage;
import pages.login_register.LoginPage;



// MAIN STARTS METHOD STARTS INITIALLY LOGIN PAGE
public class ProManager extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        LoginPage loginPage = new LoginPage(stage);
        loginPage.show();
    }

    public static void main(String[] args) throws Exception{
        MyProManager.CREATE_CONNECTION();
        launch();
    }
}
