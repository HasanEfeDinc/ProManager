package pages.tasks;

import controllers.DownloadFileController;
import controllers.ProjectManagementController;
import controllers.TaskController;
import controllers.UploadFileController;
import database.models.CurrentProject;
import database.models.Task;
import database.models.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import pages.Page;

import java.util.List;

// CREATES AND SHOWS TASK PAGE
public class TaskPage extends Page {
    private Button returnButton;
    private Button addNewTask;
    private Button removeButton;
    private Label taskLabel;
    private  Label assignedLabel;
    private Label deadlineLabel;

    private Button uploadFile;
    private Button downloadFile;
    private Label taskBody;
    private  Label assignedUser;
    private Label deadline;

    private VBox generalBox;




    public  TaskPage(Stage stage) throws Exception{
        List<Task> tasks = CurrentProject.getCurrentProjectAllTasks();
        generalBox = new VBox();
        returnButton = new Button("<- Return");
        addNewTask = new Button("Add New Task");
        downloadFile = new Button("Download Files");
        uploadFile = new Button(("Upload Files"));


        for(Task t : tasks){
            taskLabel = new Label("Task: ");
            assignedLabel = new Label("Assigned To: ");
            deadlineLabel = new Label("Deadline: ");

            deadline = new Label(t.getDeadline().toString());
            assignedUser = new Label(User.getUserById(t.getAssigned_id()).getEmail());
            taskBody = new Label(t.getBody());


            VBox leftLabels = new VBox(taskLabel,assignedLabel,deadlineLabel);
            leftLabels.setSpacing(10);

            VBox rightLabels = new VBox(taskBody,assignedUser,deadline);
            rightLabels.setSpacing(10);

            HBox hBox = new HBox(leftLabels,rightLabels);
            hBox.setAlignment(Pos.CENTER);

            removeButton = new Button("Remove");
            removeButton.setId(
                    t.getProject_id()+"-"+t.getBody()+"-"+t.getAssigned_id()
            );
            removeButton.setOnAction(TaskController.RemoveTask(stage,removeButton));


            VBox vBox = new VBox(hBox,removeButton);
            vBox.setAlignment(Pos.CENTER);
            vBox.setSpacing(10);

            generalBox.getChildren().add(vBox);
        }

        HBox hBox = new HBox(returnButton);
        hBox.setAlignment(Pos.CENTER);

        HBox hBox1 = new HBox(addNewTask);
        hBox1.setAlignment(Pos.CENTER);

        generalBox.setSpacing(20);
        generalBox.getChildren().addAll(hBox1,uploadFile,downloadFile,hBox);
        generalBox.setAlignment(Pos.CENTER);


        createPage(stage);

    }

    @Override
    protected void createPage(Stage stage) {
        super.createPage(stage);
        pane = new StackPane(generalBox);
        scene = new Scene(pane,w,h);
        stage.setScene(scene);
    }

    @Override
    protected void setHandlers() {

        downloadFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DownloadFileController.download();
            }
        });

        uploadFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                UploadFileController.upload("NewFile","txt");
            }
        });

        addNewTask.setOnAction(TaskController.AddNewTaskPage(stage));
        returnButton.setOnAction(ProjectManagementController.OpenProject(stage,CurrentProject.getCurrentProject().getTitle()));

    }
}

