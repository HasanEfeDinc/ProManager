package controllers;

import database.models.CurrentProject;
import database.models.CurrentUser;
import database.models.Project;
import database.models.UserProject;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pages.mainpage.MainPage;
import pages.progress.ProgressPage;
import project.NewProjectPage;
import project.ProjectListPage;
import project.ProjectPage;

// THE CLASS MAINLY HANDLES PROJECT CREATIONS AND PROJECT SELECTION PAGE ROUTING
// (ALSO CHECK LINE : 110-111)
public class  ProjectManagementController {

    public static EventHandler CreateProjectPage(Stage stage){
        return new EventHandler() {
            @Override
            public void handle(Event event) {
                NewProjectPage projectPage = new NewProjectPage(stage);
                projectPage.show();
            }
        };
    }

    public static EventHandler MainMenu(Stage stage){
        return new EventHandler() {
            @Override
            public void handle(Event event) {
                MainPage mainPage = new MainPage(stage);
                mainPage.show();
            }
        };
    }



    public static EventHandler CreateProject(Stage stage){
        return new EventHandler() {
            @Override
            public void handle(Event event) {
                Scene scene = stage.getScene();
                StackPane pane = (StackPane) scene.getRoot();
                VBox vBox = (VBox) pane.getChildren().getFirst();
                HBox requiredFields = (HBox) vBox.getChildren().getFirst();
                VBox inputFields = (VBox) requiredFields.getChildren().getLast();
                TextField titleField = (TextField) inputFields.getChildren().getFirst();
                TextField descriptionField = (TextField) inputFields.getChildren().getLast();
                String title = titleField.getText();
                String description = descriptionField.getText();
                try{
                    if(title.equals("") || description.equals(""))
                        throw new Exception("All fields are required !");
                    if(Project.getProjectByTitle(title) != null)
                        throw  new Exception("Project is already exist !");
                    Project.createProject(title,description);
                    Project project = Project.getProjectByTitle(title);
                    UserProject.createUserProject(
                            CurrentUser.getCurrentUser().getId(),project.getId(),true,true,true );
                    CurrentUser.getCurrentUserProjects().add(project);
                    CurrentProject.setCurrentProject(project);
                    ProjectPage projectPage = new ProjectPage(stage);
                    projectPage.show();

                }catch (Exception e){
                    System.out.println(e);
                }
            }
        };
    }

    public static EventHandler SelectProjectPage(Stage stage){
        return new EventHandler() {
            @Override
            public void handle(Event event) {
                ProjectListPage projectListPage = new ProjectListPage(stage);
                projectListPage.show();
            }
        };
    }


    public static EventHandler OpenProject(Stage stage,String title){
        return new EventHandler()  {
            @Override
            public void handle(Event event) {
                try{
                    Project currentProject = Project.getProjectByTitle(title);
                    CurrentProject.setCurrentProject(currentProject);
                    ProjectPage projectPage = new ProjectPage(stage);
                    projectPage.show();

                }catch (Exception e){

                }

            }
        };
    }

    // OPENS BAR CHART MODEL OF THE CURRENTLY AVAILABLE PROJECTS FOR THE CURRENT USER
    public static EventHandler OpenProgressPage(Stage stage){
        return new EventHandler()  {
            @Override
            public void handle(Event event) {
                try{
                    ProgressPage progressPage = new ProgressPage(stage);
                    progressPage.show();
                }catch (Exception e){

                }

            }
        };
    }


}
