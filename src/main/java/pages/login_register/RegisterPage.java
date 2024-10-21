package pages.login_register;

import controllers.AccountPageController;
import controllers.AuthenticationController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pages.Page;

// CREATES AND SHOWS REGISTER PAGE
public class RegisterPage extends Page {

    private Label emailLabel;
    private Label passwordLabel;
    private Label passwordAgainLabel;
    private TextField emailInput;
    private PasswordField passwordInput;
    private PasswordField passwordAgainInput;
    private Button loginButton;
    private Button registerButton;

    private VBox vbox = new VBox();

    public RegisterPage(Stage stage){

        emailLabel = new Label("Email: ");
        passwordLabel = new Label("Password: ");
        passwordAgainLabel = new Label("Password Again: ");
        emailInput = new TextField();
        passwordInput = new PasswordField();
        passwordAgainInput = new PasswordField();
        loginButton = new Button("Already have an account ?");
        registerButton = new Button("Sign Up");

        createPage(stage);
    }

    @Override
    protected void createPage(Stage stage) {
        super.createPage(stage);

        VBox labelsBox = new VBox(emailLabel,passwordLabel,passwordAgainLabel);
        labelsBox.setSpacing(10);

        VBox inputBox = new VBox(emailInput,passwordInput,passwordAgainInput);
        inputBox.setSpacing(10);

        VBox buttonBox = new VBox(registerButton,loginButton);
        buttonBox.setSpacing(10);


        HBox requiredFiedls = new HBox(labelsBox,inputBox);
        requiredFiedls.setAlignment(Pos.CENTER);
        requiredFiedls.setSpacing(10);

        HBox buttonHBox = new HBox(buttonBox);
        buttonHBox.setAlignment(Pos.CENTER);
        buttonHBox.setSpacing(10);

        vbox.getChildren().addAll(requiredFiedls,buttonHBox);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);

        pane = new StackPane();
        pane.getChildren().add(vbox);
        pane.setAlignment(Pos.CENTER);

        scene = new Scene(pane,w,h);
        stage.setScene(scene);

    }

    @Override
    protected void setHandlers(){
        loginButton.setOnAction(AccountPageController.LoginPage(stage));
        registerButton.setOnAction(AuthenticationController.createUser(stage,emailInput,passwordInput,passwordAgainInput,vbox));
    }



}
