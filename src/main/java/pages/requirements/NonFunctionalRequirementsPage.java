package pages.requirements;

import controllers.DownloadFileController;
import controllers.ProjectManagementController;
import controllers.RequirementsController;
import controllers.UploadFileController;
import database.models.CurrentProject;
import database.models.FunctionalRequirements;
import database.models.NonFunctionalRequirements;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pages.Page;

import java.util.List;

// CREATES AND SHOWS NEW NON-FUNCTIONAL REQUIREMENTS PAGE
public class NonFunctionalRequirementsPage extends Page {

    private Button returnButton;
    private Button addNewReq;

    private Button uploadFile;
    private Button downloadFile;
    private Button removeButton;
    private Label reqTypeLabel;
    private  Label reqBodyLabel;
    private Label reqType;
    private  Label reqBody;

    private VBox generalBox;

    public  NonFunctionalRequirementsPage(Stage stage) throws Exception{
        List<NonFunctionalRequirements> fr = CurrentProject.getCurrentProjectNonFuncReqs();
        generalBox = new VBox();
        returnButton = new Button("<- Return");
        addNewReq = new Button("Add New Requirement");
        downloadFile = new Button("Download Files");
        uploadFile = new Button(("Upload Files"));

        for(NonFunctionalRequirements f : fr){
            reqTypeLabel = new Label("Type: ");
            reqBodyLabel = new Label("Definition: ");
            reqType = new Label("Non-Functional Requirement");
            reqBody = new Label(f.getBody());

            VBox leftLabels = new VBox(reqTypeLabel,reqBodyLabel);
            leftLabels.setSpacing(10);

            VBox rightLabels = new VBox(reqType,reqBody);
            rightLabels.setSpacing(10);

            HBox hBox = new HBox(leftLabels,rightLabels);
            hBox.setAlignment(Pos.CENTER);

            removeButton = new Button("Remove");
            removeButton.setId(CurrentProject.getCurrentProject().getId()+"-"+f.getBody());
            removeButton.setOnAction(RequirementsController.RemoveRequirement(stage,removeButton,false));


            VBox vBox = new VBox(hBox,removeButton);
            vBox.setAlignment(Pos.CENTER);
            vBox.setSpacing(10);

            generalBox.getChildren().add(vBox);
        }

        HBox hBox = new HBox(returnButton);
        hBox.setAlignment(Pos.CENTER);

        HBox hBox1 = new HBox(addNewReq);
        hBox1.setAlignment(Pos.CENTER);

        generalBox.setSpacing(20);
        generalBox.setAlignment(Pos.CENTER);
        generalBox.getChildren().addAll(hBox1,downloadFile,uploadFile,hBox);

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

        addNewReq.setOnAction(RequirementsController.OpenNewReqPage(stage,false));
        returnButton.setOnAction(ProjectManagementController.OpenProject(stage,CurrentProject.getCurrentProject().getTitle()));
    }
}
