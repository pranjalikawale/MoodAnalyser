package com.bl.moodanalyser;
//This class is used for Analyse Mood
public class MoodAnalyser {
    //Declare variable
    private String message;
    //Default constructor
    public MoodAnalyser()
    {
        message=null;
    }
    /*
    contains(): It is used to check string contain another substring or not.
    isEmpty() : It is used to check string is Empty or not
    */

    //Parametrized constructor with string and initialized message according
    public MoodAnalyser(String message)
    {
        if(message == null){ // Check String is null/Empty or not
            this.message=null;
        }else if(message.contains("Sad")) // Check String with substring "SAD"
            this.message="SAD";
        else if(message.contains("Happy")) // Check String with substring "Happy"
            this.message="HAPPY";
        else
            this.message="Plz enter the valid msg.";//Set Default msg if String is improper
    }
    //This Method analyze the content of a string msg and return message.
    public String analyseMood()
    {
        try{
            if(message==null)
                throw new NullPointerException();
            return  message;
        }
        catch(NullPointerException e) {
            return "Happy";
        }
    }
}
