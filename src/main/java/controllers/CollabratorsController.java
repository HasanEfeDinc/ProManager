package controllers;

import database.models.UserProject;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import pages.collabrators.CollabratorsPage;


// CLASS FOR PAGE ROUTINGS AND EVENT HANDLING FOR EACH PROJECT COLLABRATORS
public class CollabratorsController {

    public static EventHandler OpenCaollabrators(Stage stage){
        return new EventHandler() {
            @Override
            public void handle(Event event) {
                try {
                    CollabratorsPage collabratorsPage = new CollabratorsPage(stage);
                    collabratorsPage.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    public static EventHandler UpdateUserPermission(Stage stage,int uid,int pid,String whichPerm,Boolean state){
        return new EventHandler() {
            @Override
            public void handle(Event event) {
                try {
                    UserProject.updatePermission(uid,pid,whichPerm,state);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    public static EventHandler UpdateUserPermission_writeAccess(Stage stage,String trueOrFalse){
        return new EventHandler() {
            @Override
            public void handle(Event event) {
                try {
                    CollabratorsPage collabratorsPage = new CollabratorsPage(stage);
                    collabratorsPage.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    public static EventHandler UpdateUserPermission_readAccess(Stage stage,String trueOrFalse){
        return new EventHandler() {
            @Override
            public void handle(Event event) {
                try {
                    CollabratorsPage collabratorsPage = new CollabratorsPage(stage);
                    collabratorsPage.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }


}
