package pages.login_register;

import controllers.AccountPageController;
import controllers.AppLanguageController;
import controllers.AuthenticationController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pages.Page;

import java.util.ArrayList;
import java.util.List;

// CREATES AND SHOWS LOGIN PAGE
public class LoginPage  extends Page {
    private Label emailLabel;
    private Label passwordLabel;
    private TextField emailInput;
    private PasswordField passwordInput;
    private Button loginButton;
    private Button registerButton;

    private ComboBox<String> languages;
    private VBox vbox = new VBox();

    public LoginPage(Stage stage){

        List<String>lang = new ArrayList<>();
        lang.add("English");
        lang.add("Turkish");
        lang.add("Deutsch");
        lang.add("Spanish");
        ObservableList<String> language_list = FXCollections.observableArrayList(lang);
        languages = new ComboBox<>(language_list);
        emailLabel = new Label("Email: ");
        passwordLabel = new Label("Password: ");
        emailInput = new TextField();
        passwordInput = new PasswordField();
        loginButton = new Button("Log In");
        registerButton = new Button("Create Account");
        
        createPage(stage);
    }

    @Override
    protected void createPage(Stage stage) {
       super.createPage(stage);

        VBox labelsBox = new VBox(emailLabel,passwordLabel); // Holds labels vertically
        labelsBox.setSpacing(10);

        VBox inputBox = new VBox(emailInput,passwordInput);// Holds Input Fields vertically
        inputBox.setSpacing(10);

        VBox buttonBox = new VBox(loginButton,registerButton); // Holds Buttons vertically
        buttonBox.setSpacing(10);


        HBox requiredFiedls = new HBox(labelsBox,inputBox); // Holds vertical label box and vertical input box horizantally at center
        requiredFiedls.setSpacing(10);
        requiredFiedls.setAlignment(Pos.CENTER);



        HBox buttonHBox = new HBox(buttonBox);// Holds vertical button box horizantally at center
        buttonHBox.setSpacing(10);
        buttonHBox.setAlignment(Pos.CENTER);

        HBox lanBox = new HBox(new Label("Language:"),languages);
        lanBox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(lanBox);
        vbox.getChildren().addAll(requiredFiedls,buttonHBox);// Holds hBox which holds label and input box and also holds buttonHBox at vertically center.

        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().add(vbox);

        scene = new Scene(pane,w,h);
        stage.setScene(scene);

    }
    @Override
    protected void setHandlers(){

        languages.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AppLanguageController.ChangeLanguage(languages.getValue());
            }
        });

        loginButton.setOnAction(AuthenticationController.handleAuthentication(stage,emailInput,passwordInput,vbox));
        registerButton.setOnAction(AccountPageController.RegisterPage(stage));
    }
}
