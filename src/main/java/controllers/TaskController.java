package controllers;

import database.models.*;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pages.tasks.NewTaskPage;
import pages.tasks.TaskPage;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

// ROUTING TASK PAGES AND HANDLING CREATION AND REMOVING TASKS
public class TaskController {

    public static EventHandler OpenTasks(Stage stage){
        return new EventHandler() {
            @Override
            public void handle(Event event) {
                try {
                    TaskPage taskPage = new TaskPage(stage);
                    taskPage.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    public static EventHandler AddNewTaskPage(Stage stage){
        return new EventHandler() {
            @Override
            public void handle(Event event) {
                try {
                    NewTaskPage newTaskPage = new NewTaskPage(stage);
                    newTaskPage.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    public static EventHandler RemoveTask(Stage stage, Button removeButton){
        return new EventHandler() {
            @Override
            public void handle(Event event) {
                String removeData[] = removeButton.getId().split("-");
                try {
                    Task.removeTask(Integer.valueOf(removeData[0]),removeData[1],Integer.valueOf(removeData[2]));
                    TaskPage taskPage = new TaskPage(stage);
                    taskPage.show();
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        };
    }



    public static EventHandler AddNewTask(Stage stage, DatePicker dateField, TextField taskDefInput, ComboBox<String> assignTO){
        return new EventHandler() {
            @Override
            public void handle(Event event) {
                String str_date[] = dateField.getValue().toString().split("-");
                Date date = new Date(Integer.valueOf(str_date[0])-1900,Integer.valueOf(str_date[1])-1,Integer.valueOf(str_date[2]));
                int assignedID = 0;
                try {
                    assignedID = User.getUserByEmail(assignTO.getValue()).getId();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                try {
                    Task.createTask(
                            CurrentProject.getCurrentProject().getId(),
                            assignedID,
                            taskDefInput.getText(),
                            date
                    );

                    TaskPage taskPage = new TaskPage(stage);
                    taskPage.show();

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }


            }
        };
    }

    // Lists upcoming tasks per project for each team member !
    public static List<Task> UpcomingTasks() {
        List<Task>upcomingTasks = new ArrayList<>();
        System.out.println("Reminder Your Up-Coming Tasks: ");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
        String currentDate = formatter.format(date);
        int crYY = Integer.valueOf(currentDate.split("-")[0]);
        int crMM = Integer.valueOf(currentDate.split("-")[1]);
        int crDD = Integer.valueOf(currentDate.split("-")[2]);


        for(Project p : CurrentUser.getCurrentUserProjects()) {
            CurrentProject.setCurrentProject(p);
            for (Task t : CurrentProject.getCurrentProjectAllTasks()) {
                int tYY = Integer.valueOf(t.getDeadline().toString().split("-")[0]);
                int tMM = Integer.valueOf(t.getDeadline().toString().split("-")[1]);
                int tDD = Integer.valueOf(t.getDeadline().toString().split("-")[2]);


                if (crYY <= tYY) {
                    if (crMM < tMM) {
                        upcomingTasks.add(t);
                    } else if (crMM == tMM) {
                        if (crDD <= tDD) {
                            upcomingTasks.add(t);
                        }
                    }
                }
            }
        }

        if(!upcomingTasks.isEmpty()){
            for(Task t : upcomingTasks){
                System.out.println("Assigned to :"+User.getUserById(t.getAssigned_id()).getEmail()+
                        " has a task in "+Project.getProjectById(t.getProject_id()).getTitle()
                        +" project and "+"Task: "+t.getBody());
                System.out.println("AND -> Deadline: "+ t.getDeadline());
            }
        }else System.out.println("You have not any upcoming task !");


        return CurrentUser.getCurrentUser() == null || upcomingTasks.isEmpty() ? null : upcomingTasks;
    }
}
