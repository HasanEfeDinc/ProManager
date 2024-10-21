package database.models;

import database.MyProManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.util.List;

// SQL CONNECTIONS FOR TASK CREATION  AND GETTING TASK INFORMATION
public class Task {
    private int project_id;
    private String body;
    private int assigned_id;
    private Date deadline;

    private static Statement statement;
    private static ResultSet resultSet;
    private static  final Connection connection = MyProManager.getConnection();


    public static boolean createTask(int project_id,int assigned_id,String body, Date deadline){
        try{
            statement = connection.createStatement();
            String query = "INSERT INTO task (project_id,assigned_id,body,deadline)"+"VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,project_id);
            preparedStatement.setInt(2,assigned_id);
            preparedStatement.setString(3,body);
            preparedStatement.setDate(4,deadline);
            preparedStatement.execute();
            return true;

        }catch (Exception e){
            return false;
        }
    }

    public static boolean removeTask(int project_id,String body,int assigned_id){
        try{
            statement = connection.createStatement();
            String query = "DELETE FROM task WHERE project_id=? AND body=? AND assigned_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,project_id);
            preparedStatement.setString(2,body);
            preparedStatement.setInt(3,assigned_id);
            preparedStatement.execute();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }


    public Task(){}

    public Task(int project_id, String body, int assigned_id, Date deadline) {
        this.project_id = project_id;
        this.body = body;
        this.assigned_id = assigned_id;
        this.deadline = deadline;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getAssigned_id() {
        return assigned_id;
    }

    public void setAssigned_id(int assigned_id) {
        this.assigned_id = assigned_id;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
