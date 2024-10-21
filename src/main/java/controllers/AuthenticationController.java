package controllers;

import auth.Authentication;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pages.login_register.LoginPage;
import pages.mainpage.MainPage;

// AUTHENTICATION CONTROLLER WHICH PROVIDES USER AUTHENTICATE
public class AuthenticationController {
    public static int errAuthCount = 0;
    public static int errCreationCount = 0;
    public static EventHandler handleAuthentication(Stage stage, TextField emailField,TextField passwordField,VBox vBox){
        return new EventHandler() {
            @Override
            public void handle(Event event) {

                String email = emailField.getText();
                String password = passwordField.getText();



                try {

                    boolean state = Authentication.Authenticate(email,password);
                    System.out.println(state);
                    if(state){
                        MainPage mainPage = new MainPage(stage);
                        mainPage.show();
                    }else {
                        throw  new Exception("There is no user with entered information !");
                    }

                }catch (Exception e){
                    System.out.println(e.getMessage());
                    System.out.println(" ERROR IN : public static EventHandler authenticate(Stage stage)");
                    if(errAuthCount >= 1)
                        vBox.getChildren().remove(vBox.getChildren().getLast());
                    vBox.getChildren().add(new Label(e.getMessage()));
                    errAuthCount++;

                }

            }
        };
    }

    public static EventHandler createUser(Stage stage,TextField emailField,TextField passwordField,TextField passAgainField,VBox vBox){
        return new EventHandler() {
            @Override
            public void handle(Event event) {

                String email = emailField.getText();
                String password =  passwordField.getText();
                String passwordAgain = passAgainField.getText();

                try{
                    boolean state = Authentication.Register(email,password,passwordAgain);

                    if(state){
                        LoginPage loginPage = new LoginPage(stage);
                        loginPage.show();
                    }else {
                        throw new Exception("Passwords are not matched !");
                    }


                }catch (Exception e){
                    if(errCreationCount>= 1)
                        vBox.getChildren().remove(vBox.getChildren().getLast());
                    vBox.getChildren().add(new Label(e.getMessage()));
                    errCreationCount++;

                }

            }
        };
    }

}
