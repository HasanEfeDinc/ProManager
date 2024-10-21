package controllers;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import pages.login_register.LoginPage;
import pages.login_register.RegisterPage;

// FOR LOGIN AND REGISTER PAGES BUTTON CONTROLLERS (EVENTS)
public class AccountPageController {

    public static EventHandler RegisterPage(Stage stage){
        return new EventHandler() {
            @Override
            public void handle(Event event) {
                RegisterPage registerPage = new RegisterPage(stage);
                registerPage.show();
            }
        };
    }

    public static EventHandler LoginPage(Stage stage){
        return new EventHandler() {
            @Override
            public void handle(Event event) {
                LoginPage loginPage = new LoginPage(stage);
                loginPage.show();
            }
        };
    }


}
