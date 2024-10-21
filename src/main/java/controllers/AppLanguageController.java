package controllers;

import java.util.ArrayList;
import java.util.List;

public class AppLanguageController  {

    private static final String ENGLISH = "English";
    private static final String DEUTSCH = "Deutsch";
    private static final String TURKISH = "Turkish";
    private static final String SPANISH = "Spanish";
    private static List<String> languages = new ArrayList<>();


    // CHANGES APPLICATION LANGUAGE ACCORDING TO SELECTED LANGUAGE (SLECTED LANGUAGE MUST BE ONE OF THESE STATIC FINAL STRINGS)
    public static boolean ChangeLanguage(String language){

        languages.add(ENGLISH);
        languages.add(DEUTSCH);
        languages.add(TURKISH);
        languages.add(SPANISH);

        boolean isMatched = false;
        for(String l :  languages){
            if(l.equals(language))
                isMatched = true;
        }

        if(isMatched) System.out.println("Language has been changed to "+language);
        else System.out.println("Language cannot be changed to "+language);

        return isMatched;

    }
}
