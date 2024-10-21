package pages.collabrators;

import controllers.CollabratorsController;
import controllers.ProjectManagementController;
import database.models.CurrentProject;
import database.models.User;
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

import java.util.List;


// SHOWS COLLABRATORS PAGE
public class CollabratorsPage extends Page {

    private Label emailLabel;
    private Label isAdminLabel;
    private Label writeAccessLabel;
    private Label readAccessLabel;


    private Label email;
    private RadioButton isAdmin;
    private RadioButton isNotAdmin;

    private RadioButton hasWrite;
    private RadioButton hasNotWrite;
    private RadioButton hasRead;
    private RadioButton hasNotRead;

    private VBox generalBox;
    private Button returnButton;
    private Button addNewCollabrator;



    public CollabratorsPage(Stage stage) throws Exception{
        List<User>collabrators = CurrentProject.getCollabrators();


        generalBox = new VBox();
        returnButton = new Button("<- Return");
        addNewCollabrator = new Button("Add New Collabrator");

        for(User u :collabrators){
            emailLabel      = new Label("Email: ");
            isAdminLabel    = new Label("Is Admin: ");
            writeAccessLabel= new Label("Write Accesss: ");
            readAccessLabel = new Label("Read Access: ");


            email = new Label(u.getEmail());
            isAdmin = new RadioButton("True");
            isNotAdmin = new RadioButton("False");
            hasWrite = new RadioButton("True");
            hasNotWrite = new RadioButton("False");
            hasRead = new RadioButton("True");
            hasNotRead = new RadioButton("False");


            if(User.userPermissons(u.getId()).get("is_admin")){
                isAdmin.fire();
                isNotAdmin.disarm();
            }else {
                isAdmin.disarm();
                isNotAdmin.fire();
            }
            if(User.userPermissons(u.getId()).get("write_access")){
                hasWrite.fire();
                hasNotWrite.disarm();
            }else {
                hasWrite.disarm();
                hasNotWrite.fire();
            }

            if(User.userPermissons(u.getId()).get("read_access")){
                hasRead.fire();
                hasNotRead.disarm();
            }else {
                hasRead.disarm();
                hasNotRead.fire();
            }

            if(User.userPermissons(u.getId()).get("is_admin")){
                isAdmin.setDisable(true);
                isNotAdmin.setDisable(true);
                hasRead.setDisable(true);
                hasNotRead.setDisable(true);
                hasWrite.setDisable(true);
                hasNotWrite.setDisable(true);
            }

            VBox leftBox = new VBox(emailLabel,isAdminLabel,writeAccessLabel,readAccessLabel);
            leftBox.setSpacing(10);
            leftBox.setAlignment(Pos.CENTER);

            ToggleGroup adminControl = new ToggleGroup();
            isAdmin.setToggleGroup(adminControl);
            isNotAdmin.setToggleGroup(adminControl);


            ToggleGroup writeAccessControl = new ToggleGroup();
            hasWrite.setToggleGroup(writeAccessControl);
            hasNotWrite.setToggleGroup(writeAccessControl);

            ToggleGroup readAccessControl = new ToggleGroup();
            hasRead.setToggleGroup(readAccessControl);
            hasNotRead.setToggleGroup(readAccessControl);



            isAdmin.setOnAction(
                    CollabratorsController.UpdateUserPermission(stage, u.getId(),
                    CurrentProject.getCurrentProject().getId(),"is_admin",true));
            isNotAdmin.setOnAction(CollabratorsController.UpdateUserPermission(stage, u.getId(),
                    CurrentProject.getCurrentProject().getId(),"is_admin",false));
            hasWrite.setOnAction(CollabratorsController.UpdateUserPermission(stage, u.getId(),
                    CurrentProject.getCurrentProject().getId(),"write_access",true));
            hasNotWrite.setOnAction(CollabratorsController.UpdateUserPermission(stage, u.getId(),
                    CurrentProject.getCurrentProject().getId(),"write_access",false));
            hasRead.setOnAction(CollabratorsController.UpdateUserPermission(stage, u.getId(),
                    CurrentProject.getCurrentProject().getId(),"read_access",true));
            hasNotRead.setOnAction(CollabratorsController.UpdateUserPermission(stage, u.getId(),
                    CurrentProject.getCurrentProject().getId(),"read_access",false));




            VBox rightBox = new VBox(
                    new HBox(email),
                    new HBox(isAdmin,isNotAdmin),
                    new HBox(hasWrite,hasNotWrite),
                    new HBox(hasRead,hasNotRead)
            );

            rightBox.setSpacing(10);
            rightBox.setAlignment(Pos.CENTER);

            Button removeButton = new Button("Remove");
            HBox hBox = new HBox(leftBox,rightBox);
            hBox.setAlignment(Pos.CENTER);
            generalBox.getChildren().addAll(hBox,removeButton);
        }

        generalBox.setAlignment(Pos.CENTER);
        generalBox.setSpacing(20);
        generalBox.getChildren().addAll(addNewCollabrator,returnButton);
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
        returnButton.setOnAction(ProjectManagementController.OpenProject(stage,CurrentProject.getCurrentProject().getTitle()));

    }
}
