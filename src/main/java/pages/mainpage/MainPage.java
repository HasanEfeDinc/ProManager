package pages.mainpage;

import controllers.ProjectManagementController;
import database.models.CurrentUser;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pages.Page;

// CREATES AND SHOWS MAIN PAGE WHICH HAS OPEN-PROJECT AND CREATE-PROJECT OPTIONS

public class MainPage extends Page {

    private Button createProjectButton ;
    private Button openProjectButton;



    public MainPage(Stage stage){
        createProjectButton = new Button("Create Project");
        openProjectButton = new Button("Open Project");
        if(CurrentUser.getCurrentUserProjects().size() == 0)
            openProjectButton.setDisable(true);
        createPage(stage);
    }

    @Override
    protected void createPage(Stage stage) {
       super.createPage(stage);
        VBox vBox = new VBox(createProjectButton,openProjectButton); // holds only 2 buttons
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        scene = new Scene(vBox,w,h);
        stage.setScene(scene);
    }

    @Override
    protected void setHandlers() {
        createProjectButton.setOnAction(ProjectManagementController.CreateProjectPage(stage));
        openProjectButton.setOnAction(ProjectManagementController.SelectProjectPage(stage));
    }
}
