package database.models;

import database.MyProManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


// HOLDS CURRENT CHOSEN PROJECT
public class CurrentProject {
    private static Project currentProject;
    private static List<User>collabrators;

    private static List<FunctionalRequirements>functionalRequirements;
    private static List<NonFunctionalRequirements>nonFunctionalRequirements;

    private static Statement statement;
    private static ResultSet resultSet;
    private static  final Connection connection = MyProManager.getConnection();

    public static void setCurrentProject(Project currentProject) {
        CurrentProject.currentProject = currentProject;
    }


    public static List<User>getCollabrators () {
        try{
            collabrators = new ArrayList<>();
            statement = connection.createStatement();
            String query = "SELECT * FROM user_project WHERE project_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,currentProject.getId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int uid = resultSet.getInt("user_id");
                if(uid != CurrentUser.getCurrentUser().getId()){
                    collabrators.add(User.getUserById(uid));
                }
            }
            return collabrators;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }


    public static List<Task> getCurrentProjectAllTasks(){
        try{
            List<Task>allTasks = new ArrayList<>();
            statement = connection.createStatement();
            String query = "SELECT * FROM task WHERE project_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,currentProject.getId());
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id =resultSet.getInt("project_id");
                String body = resultSet.getString("body");
                Date deadline = resultSet.getDate("deadline");
                int assigned_id = resultSet.getInt("assigned_id");

                Task task = new Task(id,body,assigned_id,deadline);
                allTasks.add(task);
            }
            return allTasks;
        }catch (Exception e){
            System.out.println(e);
            return  null;
        }
    }


    public static List<FunctionalRequirements> getCurrentProjectFuncReqs(){
        try{
            functionalRequirements = new ArrayList<>();
            statement = connection.createStatement();
            String query = "SELECT * FROM functional_requirement WHERE project_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,currentProject.getId());
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id =resultSet.getInt("project_id");
                String body = resultSet.getString("body");

                functionalRequirements.add(new FunctionalRequirements(id,body));
            }
            return functionalRequirements;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public static List<NonFunctionalRequirements> getCurrentProjectNonFuncReqs(){
        try{
            nonFunctionalRequirements = new ArrayList<>();
            statement = connection.createStatement();
            String query = "SELECT * FROM non_functional_requirement WHERE project_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,currentProject.getId());
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id =resultSet.getInt("project_id");
                String body = resultSet.getString("body");

                nonFunctionalRequirements.add(new NonFunctionalRequirements(id,body));
            }
            return nonFunctionalRequirements;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }


    public static Project getCurrentProject() {
        return currentProject;
    }
}
