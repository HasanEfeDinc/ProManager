package database.models;

import database.MyProManager;

import java.sql.*;
import java.util.HashMap;
import java.util.List;

// CURRENTLY LOGGED IN USER INFORMATION
public class CurrentUser {
    private static User currentUser ;

    private static List<Project>currentUserProjects;

    private static Statement statement;
    private static ResultSet resultSet;
    private static  final Connection connection = MyProManager.getConnection();

    public static HashMap<String,Boolean> currentUserPermissons(){
        try{
            HashMap<String,Boolean> permissions = new HashMap<>();

            if(CurrentProject.getCurrentProject() != null){
                statement = connection.createStatement();
                String query = "SELECT * FROM user_project WHERE project_id=? AND user_id=?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1,CurrentProject.getCurrentProject().getId());
                preparedStatement.setInt(2,currentUser.getId());
                resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    int pid =resultSet.getInt("project_id");
                    int uid =resultSet.getInt("user_id");
                    boolean is_admin = resultSet.getBoolean("is_admin");
                    boolean write_access = resultSet.getBoolean("write_access");
                    boolean read_access = resultSet.getBoolean("read_access");

                    permissions.put("is_admin",is_admin);
                    permissions.put("write_access",write_access);
                    permissions.put("read_access",read_access);
                }
            }else{
                throw new Exception("Current User is Null !");
            }
            return permissions;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public static void setCurrentUser(User currentUser) {
        CurrentUser.currentUser = currentUser;
    }

    public static void setCurrentUserProjects(List<Project> currentUserProjects) {
        CurrentUser.currentUserProjects = currentUserProjects;
    }

    public static List<Project> getCurrentUserProjects() {
        return currentUserProjects;
    }

    public static User getCurrentUser() {
        return currentUser;
    }
}
