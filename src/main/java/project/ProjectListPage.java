package project;

import controllers.ProjectManagementController;
import controllers.TaskController;
import database.models.CurrentProject;
import database.models.CurrentUser;
import database.models.Project;
import database.models.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pages.Page;

import java.sql.Date;
import java.util.Objects;

// SHOWS LIST OF ALL PROJECTS OF THE CURRENT USER (USER WHO IS LOGGED IN TO THE SYSTEM)
public class ProjectListPage extends Page {
    private Button returnButton;
    private Button progress;

    public ProjectListPage(Stage stage){
        returnButton = new Button("<- Return");
        progress = new Button("Progress");
        createPage(stage);
    }
    @Override
    protected void createPage(Stage stage) {
        super.createPage(stage);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        for(Project p :CurrentUser.getCurrentUserProjects()){
            Button button  = new Button(p.getTitle());
            button.setOnAction(ProjectManagementController.OpenProject(stage,p.getTitle()));
            vBox.getChildren().add(button);
        }

        TaskController.UpcomingTasks();


        vBox.getChildren().add(progress);
        vBox.getChildren().add(returnButton);

        HBox hBox = new HBox(vBox);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        pane = new StackPane(hBox);
        pane.setAlignment(Pos.CENTER);

        scene = new Scene(pane,w,h);
        stage.setScene(scene);


    }

    @Override
    protected void setHandlers() {
        progress.setOnAction(ProjectManagementController.OpenProgressPage(stage));
        returnButton.setOnAction(ProjectManagementController.MainMenu(stage));
    }
}
