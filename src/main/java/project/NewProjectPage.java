package project;

import controllers.ProjectManagementController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.w3c.dom.Text;
import pages.Page;

// PAGE FOR NEW PROJECT || INCLUDES INPUT FIELDS
public class NewProjectPage extends Page {

    private Label titleLabel ;
    private Label descriptionLabel;
    private TextField titleInput ;
    private TextField descriptionInput;
    private Button doneButton;

    private  Button returnButton;



    public NewProjectPage(Stage stage){
        titleLabel = new Label("Project Title: ");
        descriptionLabel = new Label("Project Description: ");
        titleInput = new TextField();
        descriptionInput = new TextField();
        doneButton = new Button("Done !");
        returnButton = new Button("<- Return");
        createPage(stage);
    }

    @Override
    protected void createPage(Stage stage) {
        super.createPage(stage);

        VBox labelBox = new VBox(titleLabel,descriptionLabel); // holds title label and description label
        labelBox.setSpacing(10);

        VBox inputBox = new VBox(titleInput,descriptionInput);// holds title inputfield and descrp. inputfield
        inputBox.setSpacing(10);

        HBox requiredFields = new HBox(labelBox,inputBox); // holds 2 boxes which holds labels and inputfields
        requiredFields.setAlignment(Pos.CENTER);


        VBox bottomVBox = new VBox(doneButton,returnButton);// Holds buttons horizantally
        bottomVBox.setAlignment(Pos.CENTER);
        bottomVBox.setSpacing(10);


        VBox vBox = new VBox(requiredFields,bottomVBox);// holds requiredFields(labelbox and inputbox) and bottomHBox vertically.
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);



        pane = new StackPane();
        pane.getChildren().add(vBox);
        pane.setAlignment(Pos.CENTER);


        scene = new Scene(pane,w,h);
        stage.setScene(scene);


    }

    @Override
    protected void setHandlers() {
        doneButton.setOnAction(ProjectManagementController.CreateProject(stage));
        returnButton.setOnAction(ProjectManagementController.MainMenu(stage));
    }
}
