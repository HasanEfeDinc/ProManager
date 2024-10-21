package database.models;

import database.MyProManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;


// SQL CONNECTIONS FOR USER CREATION  AND GETTING USER INFORMATION
public class User {

    private int id;
    private String email;
    private String password;
    private static Statement statement;
    private static ResultSet resultSet;
    private static  final Connection connection = MyProManager.getConnection();

    public User (){}
    public User(int id, String email,String password) {
        this.email = email;
        this.id = id;
        this.password = password;
    }

    public static boolean createUser(String email,String password) {
        try{
            statement = connection.createStatement();
            String query = "INSERT INTO user (email,password)"+"VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            preparedStatement.execute();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }

    }
    public static User getUserById(int ID)   {
        try {
            User user = null;
            statement = connection.createStatement();
            String query = "SELECT * FROM user WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,ID);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id =resultSet.getInt("id");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                user = new User(id,email,password);
            }
            return user;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public static User getUserByEmail(String email)   {
        try{
            User user = null;
            statement = connection.createStatement();
            String query = "SELECT * FROM user WHERE email=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,email);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id =resultSet.getInt("id");
                String mail = resultSet.getString("email");
                String password = resultSet.getString("password");
                user = new User(id,mail,password);
            }
            return user;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }


    public static HashMap<String,Boolean> userPermissons(int ID)   {
        try{
            HashMap<String,Boolean> permissions = new HashMap<>();

            if(CurrentProject.getCurrentProject() != null){
                statement = connection.createStatement();
                String query = "SELECT * FROM user_project WHERE project_id=? AND user_id=?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1,CurrentProject.getCurrentProject().getId());
                preparedStatement.setInt(2,ID);
                resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    boolean is_admin = resultSet.getBoolean("is_admin");
                    boolean write_access = resultSet.getBoolean("write_access");
                    boolean read_access = resultSet.getBoolean("read_access");

                    permissions.put("is_admin",is_admin);
                    permissions.put("write_access",write_access);
                    permissions.put("read_access",read_access);
                }
            }
            if(permissions.isEmpty())
                throw new Exception();
            return  permissions;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
