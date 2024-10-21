package pages.requirements;

import controllers.RequirementsController;
import database.models.CurrentProject;
import database.models.NonFunctionalRequirements;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pages.Page;

// CREATES AND SHOWS NEW NON-FUNCTIONAL REQUIREMENTS PAGE || INPUTS FOR NEW REQUIREMENTS
public class NewNonFuncPage extends Page {

    private Label requirementType;
    private TextField requirementTypeInput;

    private Label definition;
    private TextField definitionInput;

    private Button done;
    private Button returnButton;

    private VBox generalBox;



    public NewNonFuncPage(Stage stage){

        requirementType = new Label("Requirement Type: ");
        definition = new Label("Definition: ");
        requirementTypeInput = new TextField();
        requirementTypeInput.setText("Non-Functional Requirement");
        requirementTypeInput.setDisable(true);
        definitionInput = new TextField();


        done = new Button("Done");
        returnButton = new Button("<- return");

        createPage(stage);
    }

    @Override
    protected void createPage(Stage stage) {
        super.createPage(stage);

        VBox labels = new VBox();
        labels.getChildren().addAll(requirementType,definition);
        labels.setSpacing(10);
        VBox inputs  = new VBox();
        inputs.getChildren().addAll(requirementTypeInput,definitionInput);
        inputs.setSpacing(10);


        HBox hBox = new HBox();
        hBox.getChildren().addAll(labels,inputs);
        hBox.setAlignment(Pos.CENTER);

        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(returnButton,done);
        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.CENTER);

        generalBox = new VBox();
        generalBox.setSpacing(10);
        generalBox.getChildren().addAll(hBox,buttonBox);
        generalBox.setAlignment(Pos.CENTER);

        pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().add(generalBox);

        scene = new Scene(pane,w,h);
        stage.setScene(scene);

    }


    @Override
    protected void setHandlers() {
        done.setOnAction(RequirementsController.addNewRequirements(stage,definitionInput,generalBox,false));
        returnButton.setOnAction(RequirementsController.OpenNonFuncRequirements(stage));

    }
}
