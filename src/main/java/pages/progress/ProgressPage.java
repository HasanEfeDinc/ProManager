package pages.progress;

import controllers.ProjectManagementController;
import controllers.TaskController;
import database.models.CurrentUser;
import database.models.Project;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pages.Page;

import java.util.Random;

public class ProgressPage extends Page {
    private Button returnButton;
    private int projectCount = CurrentUser.getCurrentUserProjects().size();

    public ProgressPage(Stage stage){
        returnButton = new Button("<- Return");
        createPage(stage);
    }
    @Override
    protected void createPage(Stage stage) {
        super.createPage(stage);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);



// CHART IMPLEMENTATION ------------------------------------------------------------------

        CategoryAxis x = new CategoryAxis();
        x.setLabel("Project Name");
        NumberAxis y = new NumberAxis();
        y.setLabel("Progress");

        final StackedBarChart<String, Number> stackedBarChart =
                new StackedBarChart<>(x, y);



        XYChart.Series series = new XYChart.Series();
        series.setName("The Progress Of Your Projects");
        for(Project p : CurrentUser.getCurrentUserProjects()){
            series.getData().add(new XYChart.Data(p.getTitle(), new Random().nextInt(20 - 0 + 1) + 0));
        }


        stackedBarChart.getData().add(series);
// CHART IMPLEMENTATION ------------------------------------------------------------------

        vBox.getChildren().add(stackedBarChart);
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
        returnButton.setOnAction(ProjectManagementController.SelectProjectPage(stage));
    }
}
