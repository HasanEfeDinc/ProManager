package database.models;

import database.MyProManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


// SQL CONNECTIONS FOR NON-FUNCTIONAL REQUIREMENTS
public class NonFunctionalRequirements {

    private int project_id;
    private  String body;

    private static Statement statement;
    private static ResultSet resultSet;
    private static  final Connection connection = MyProManager.getConnection();


    public static boolean createNonFuncReq(int project_id,String body)  {
        try {
            statement = connection.createStatement();
            String query = "INSERT INTO non_functional_requirement (project_id,body)"+"VALUES (?,?)";
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

    public static boolean removeNonFuncReq(int project_id,String body)  {
        try {

            statement = connection.createStatement();
            String query = "DELETE FROM non_functional_requirement WHERE project_id = ? AND body = ?";
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


    public NonFunctionalRequirements(){}

    public NonFunctionalRequirements(int project_id, String body) {
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
