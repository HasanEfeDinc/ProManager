package controllers;

import java.util.List;

public class FileShareController {

    // Shares files if filename exists in the files list
    public static boolean share(String fileName, String... files){
        boolean is_shared = false;
        for(String f : files){
            if(f.equals(fileName))
                is_shared = true;
        }
        if(is_shared)
            System.out.println("Files have been shared !");
        else System.out.println("Files cannot be shared !");
        return is_shared;
    }
}
