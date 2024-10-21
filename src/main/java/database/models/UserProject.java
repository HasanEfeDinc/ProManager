package database.models;

import database.MyProManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


// SQL CONNECTIONS FOR USER_PROJECT CREATION  AND GETTING USER_PROJECT INFORMATION TO HANDLE ROLES
public class UserProject {
    private int user_id;
    private int project_id;
    private boolean  is_admin;
    private boolean read_access;
    private boolean write_access;

    private static Statement statement;
    private static ResultSet resultSet;
    private static  final Connection connection = MyProManager.getConnection();

    UserProject(){}

    public UserProject(int user_id, int project_id, boolean is_admin, boolean read_access, boolean write_access) {
        this.user_id = user_id;
        this.project_id = project_id;
        this.is_admin = is_admin;
        this.read_access = read_access;
        this.write_access = write_access;
    }

    public static boolean createUserProject(int user_id,int project_id,boolean is_admin,boolean write_access,boolean read_access) {
        try{
            statement = connection.createStatement();
            if(is_admin){
                write_access = true;
                read_access = true;
            }
            String query = "INSERT INTO user_project (user_id,project_id,is_admin,read_access,write_access)"+"VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,user_id);
            preparedStatement.setInt(2,project_id);
            preparedStatement.setBoolean(3,is_admin);
            preparedStatement.setBoolean(4,write_access);
            preparedStatement.setBoolean(5,read_access);
            preparedStatement.execute();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public static List<Project> getProjectListByUserId(int ID)  {
        try{
            List<Project>projects= new ArrayList<>();
            statement = connection.createStatement();
            String query = "SELECT * FROM user_project WHERE user_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,ID);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Project p = Project.getProjectById(resultSet.getInt("project_id"));
                projects.add(p);
            }
            if(projects.isEmpty())
                throw  new Exception();
            return projects;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public static boolean updatePermission(int user_id,int project_id,String whichPerm,boolean state){
        try {
            statement = connection.createStatement();
            String query = String.format(" UPDATE user_project SET %s = %s",whichPerm,state)+" WHERE project_id=? AND user_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,project_id);
            preparedStatement.setInt(2,user_id);
            preparedStatement.execute();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public boolean isRead_access() {
        return read_access;
    }

    public void setRead_access(boolean read_access) {
        this.read_access = read_access;
    }

    public boolean isWrite_access() {
        return write_access;
    }

    public void setWrite_access(boolean write_access) {
        this.write_access = write_access;
    }

    @Override
    public String toString() {
        return "UserProject{" +
                "user_id=" + user_id +
                ", project_id=" + project_id +
                ", is_admin=" + is_admin +
                ", read_access=" + read_access +
                ", write_access=" + write_access +
                '}';
    }
}
