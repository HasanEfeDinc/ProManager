package controllers;

public class UploadFileController {

    // Uploads files with its name and its filetype
    public static boolean upload(String fileName, String fileType){
        if(fileType.equals("txt")){
            System.out.println(fileName+"."+fileType+" has been uploaded !");
            return true;
        }
        else {
            System.out.println("File type: " +fileType+" cannot be uploaded ! It must be '.txt' file !");
            return false;
        }
    }
}
