package project;

import controllers.*;
import database.models.CurrentProject;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pages.Page;

// SHOWS FEATURES WITH BUTTONS OF SELECTED PROJECT
public class
ProjectPage extends Page {
    private Label title;
    private VBox menu;
    private Button funcRequirements;
    private Button unFuncRequirements;

    private Button collabrators;
    private Button assignedTasks;
    private Button returnButton;

    private Button shareFiles;

    private HBox generalPageDesigner;

    private HBox projectInfo;


    public ProjectPage(Stage stage){
        funcRequirements = new Button("Functional Requirements");
        unFuncRequirements = new Button("Non Functional Requirements");
        title = new Label(":---------- "+CurrentProject.getCurrentProject().getTitle()+" ----------:");
        title.setFont(new Font(30));
        collabrators = new Button("Collabrators");
        shareFiles = new Button("Share Project Files");
        assignedTasks = new Button("Assigned Tasks");
        returnButton = new Button("<- Return");


        menu = new VBox(title,collabrators,assignedTasks,funcRequirements,unFuncRequirements,shareFiles,returnButton);
        menu.setAlignment(Pos.CENTER);
        menu.setSpacing(10);

        generalPageDesigner = new HBox(menu);
        generalPageDesigner.setAlignment(Pos.CENTER);


        createPage(stage);
    }

    @Override
    protected void createPage(Stage stage) {
        super.createPage(stage);



        pane = new StackPane(generalPageDesigner);
        scene = new Scene(pane,w,h);
        stage.setScene(scene);

    }

    @Override
    protected void setHandlers() {
        shareFiles.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                boolean isShared = FileShareController.share(CurrentProject.getCurrentProject().getTitle(),CurrentProject.getCurrentProject().getTitle());}
        });
        returnButton.setOnAction(ProjectManagementController.SelectProjectPage(stage));
        assignedTasks.setOnAction(TaskController.OpenTasks(stage));
        unFuncRequirements.setOnAction(RequirementsController.OpenNonFuncRequirements(stage));
        funcRequirements.setOnAction(RequirementsController.OpenFuncRequirements(stage));
        collabrators.setOnAction(CollabratorsController.OpenCaollabrators(stage));
    }
}
