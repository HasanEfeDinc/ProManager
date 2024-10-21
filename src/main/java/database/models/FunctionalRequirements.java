package database.models;

import database.MyProManager;

import java.sql.*;


// SQL CONNECTIONS FOR FUNCTIONAL REQUIREMENTS
public class FunctionalRequirements {
    private int project_id;
    private  String body;

    private static Statement statement;
    private static ResultSet resultSet;
    private static  final Connection connection = MyProManager.getConnection();


    public static boolean createFuncReq(int project_id,String body)  {
        try{
            statement = connection.createStatement();
            String query = "INSERT INTO functional_requirement (project_id,body)"+"VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,project_id);
            preparedStatement.setString(2,body);
            preparedStatement.execute();
            return  true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public static boolean removeFuncReq(int project_id,String body)  {
        try{
            statement = connection.createStatement();
            String query = "DELETE FROM functional_requirement WHERE project_id = ? AND body = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,project_id);
            preparedStatement.setString(2,body);
            preparedStatement.execute();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }



    public FunctionalRequirements(){}

    public FunctionalRequirements(int project_id, String body) {
        this.project_id = project_id;
        this.body = body;
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
}
