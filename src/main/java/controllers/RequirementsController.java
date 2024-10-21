package controllers;

import database.models.CurrentProject;
import database.models.FunctionalRequirements;
import database.models.NonFunctionalRequirements;
import database.models.Task;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pages.requirements.FunctionalRequirementsPage;
import pages.requirements.NewFuncReqPage;
import pages.requirements.NewNonFuncPage;
import pages.requirements.NonFunctionalRequirementsPage;
import pages.tasks.TaskPage;

// ROUTING REQUIREMENTS PAGES AND HANDLING CREATION AND REMOVING REQUIREMENTS
public class RequirementsController {

    public static EventHandler OpenFuncRequirements(Stage stage){
        return new EventHandler() {
            @Override
            public void handle(Event event) {
                try {
                    FunctionalRequirementsPage f = new FunctionalRequirementsPage(stage);
                    f.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        };
    }

    public static EventHandler OpenNonFuncRequirements(Stage stage){
        return new EventHandler() {
            @Override
            public void handle(Event event) {
                try {
                    NonFunctionalRequirementsPage f = new NonFunctionalRequirementsPage(stage);
                    f.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        };
    }

    public static EventHandler OpenNewReqPage(Stage stage,boolean is_functional){
        return new EventHandler()  {
            @Override
            public void handle(Event event) {
                try{
                if(is_functional){
                    NewFuncReqPage p = new NewFuncReqPage(stage);
                    p.show();
                }else{
                    NewNonFuncPage p = new NewNonFuncPage(stage);
                    p.show();
                }

                }catch (Exception e){
                    System.out.println(e);
                }

            }
        };
    }

    public static EventHandler RemoveRequirement(Stage stage, Button removeButton,boolean is_functional){
        return new EventHandler() {
            @Override
            public void handle(Event event) {
                String removeData[] = removeButton.getId().split("-");
                try {
                    if(is_functional){
                        FunctionalRequirements.removeFuncReq(Integer.valueOf(removeData[0]),removeData[1]);
                        FunctionalRequirementsPage page = new FunctionalRequirementsPage(stage);
                        page.show();
                    }else{
                        NonFunctionalRequirements.removeNonFuncReq(Integer.valueOf(removeData[0]),removeData[1]);
                        NonFunctionalRequirementsPage page = new NonFunctionalRequirementsPage(stage);
                        page.show();
                    }
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        };
    }

    public static EventHandler addNewRequirements(Stage stage, TextField definitionInput, VBox generalBox,boolean is_functional){
        return new EventHandler() {
            @Override
            public void handle(Event event) {
                try {
                    if(!definitionInput.getText().equals("")){
                        int pId = CurrentProject.getCurrentProject().getId();
                        if(is_functional){
                            FunctionalRequirements.createFuncReq(pId,definitionInput.getText());
                            FunctionalRequirementsPage f = new FunctionalRequirementsPage(stage);
                            f.show();
                        }else {
                            NonFunctionalRequirements.createNonFuncReq(pId,definitionInput.getText());
                            NonFunctionalRequirementsPage f = new NonFunctionalRequirementsPage(stage);
                            f.show();
                        }
                    }else{
                        throw new Exception("Definition part is required !");
                    }
                }catch (Exception e){
                    if(generalBox.getChildren().getLast() instanceof Label)
                        generalBox.getChildren().remove(generalBox.getChildren().getLast());
                    else generalBox.getChildren().add(new Label(e.getMessage()));
                }
            }
        };
    }

}
