package database.models;

import database.MyProManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


// SQL CONNECTIONS FOR PROJECT CREATION  AND GETTING PROJECT INFORMATION
public class Project {
    private int id;
    private String title;
    private String description;

    private static Statement statement;
    private static ResultSet resultSet;
    private static  final Connection connection = MyProManager.getConnection();

    public Project(){}

    public Project(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }


    public static boolean createProject(String title,String description){
        try{
            statement = connection.createStatement();
            String query = "INSERT INTO project (title,description)"+"VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,description);
            preparedStatement.execute();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }

    }

    public static Project getProjectById(int ID)   {
        try{
            Project project = null;
            statement = connection.createStatement();
            String query = "SELECT * FROM project WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,ID);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id =resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                project = new Project(id,title,description);
            }
            return project;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public static Project getProjectByTitle(String title)   {
        try{
            Project project = null;
            statement = connection.createStatement();
            String query = "SELECT * FROM project WHERE title=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,title);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id =resultSet.getInt("id");
                String pTitle = resultSet.getString("title");
                String description = resultSet.getString("description");
                project = new Project(id,pTitle,description);
            }
            return project;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

