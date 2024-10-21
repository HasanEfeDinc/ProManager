package pages.tasks;

import controllers.TaskController;
import database.models.CurrentProject;
import database.models.CurrentUser;
import database.models.Task;
import database.models.User;
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
import java.sql.Date;
import java.util.List;

// CREATES AND SHOWS NEW TASK  PAGE || INPUTS FOR NEW TASKS
public class NewTaskPage extends Page {
    private Label taskDefinition;
    private TextField taskDefInput;

    private Label assignments;
    private Label deadline;
    private ComboBox<String> assignTO;

    private DatePicker dateField;

    private Button done;
    private Button returnButton;

    private VBox generalBox;

    public NewTaskPage(Stage stage) throws Exception {
        taskDefinition = new Label("Task:");
        taskDefInput = new TextField();

        assignments = new Label("Assigned To:");
        List<User>collabrators = CurrentProject.getCollabrators();
        List<String>Emails = new ArrayList<>();
        for(User u : collabrators){
            Emails.add(u.getEmail());
        }
        Emails.add(CurrentUser.getCurrentUser().getEmail());
        ObservableList<String>mails = FXCollections.observableArrayList(Emails);
        assignTO = new ComboBox<>(mails);

        deadline = new Label("DeadLine:");
        dateField = new DatePicker();

        VBox leftLabels = new VBox(taskDefinition,assignments,deadline);
        leftLabels.setSpacing(10);

        VBox rightLabels = new VBox(taskDefInput,assignTO,dateField);
        rightLabels.setSpacing(10);

        HBox hBox = new HBox(leftLabels,rightLabels);
        hBox.setAlignment(Pos.CENTER);



        done = new Button("Done");
        returnButton = new Button("<- Return");

        VBox buttons = new VBox(done,returnButton);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(10);

        generalBox = new VBox(hBox,buttons);
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
        returnButton.setOnAction(TaskController.OpenTasks(stage));
        done.setOnAction(TaskController.AddNewTask(stage,dateField,taskDefInput,assignTO));
    }
}
