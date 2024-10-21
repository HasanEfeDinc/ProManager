package auth;

import database.models.CurrentUser;
import database.models.Project;
import database.models.User;
import database.models.UserProject;
import encryption.SHA_256_Encryption;

import java.util.ArrayList;
import java.util.List;

// AUTHENTICATION CLASS WHICH INCLUDES AUTHENTICATE AND REGISTER METHODS
public class Authentication {

    // CHECK EMAIL AND PASSWORD
    public static boolean Authenticate(String email, String password) {
        try{
            try {
                SHA_256_Encryption.getSHA(password);
            }catch (Exception e){
                System.out.println(e);
            }
            password = SHA_256_Encryption.toHexString();
            User user = User.getUserByEmail(email);

            if(user != null){
                if(user.getPassword().equals(password)){
                    CurrentUser.setCurrentUser(user);
                    List<Project> projects = UserProject.getProjectListByUserId(CurrentUser.getCurrentUser().getId());
                    if( projects == null )
                        projects = new ArrayList<>();
                    CurrentUser.setCurrentUserProjects(projects);

                }else{
                    throw new Exception("Your password is incorrect !");
                }
            }else{
                throw  new Exception("There is no user with entered information !");
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //            throw  new Exception("There is no user with entered information !");


    // CREATES NEW USER
    public static boolean Register(String email, String password, String passwordAgain){
        try{
            String[] splittedEmail = email.split("@");
            if(email.equals("") || email.trim().equals(""))
                throw  new Exception("Email field is required !");
            if(
                    !email.contains("@")    ||
                            (!email.contains(".com") &&
                                    !email.contains(".net") &&
                                    !email.contains(".org") &&
                                    !email.contains(".edu.tr"))

            ){
                throw new Exception("Invalid email type !");
            }

            if(splittedEmail[0].length()<3)
                throw new Exception("Invalid email type !");
            if(email.contains(".edu.tr")){
                if(splittedEmail[1].length()<10)
                    throw  new Exception(" Invalid email type !");
            }
            if(email.contains(".net")||email.contains(".com")||email.contains(".org")){
                if(splittedEmail[1].length()<7)
                    throw  new Exception(" Invalid email type !");
            }

            if(!password.equals(passwordAgain))
                throw new Exception("Passwords are not matched !");
            if(password.equals("") || passwordAgain.equals(""))
                throw  new Exception("Password fields are required !");

            SHA_256_Encryption.getSHA(password);
            User.createUser(email,SHA_256_Encryption.toHexString());

            return true;
        }catch (Exception e){
            return  false;
        }
    }
}
