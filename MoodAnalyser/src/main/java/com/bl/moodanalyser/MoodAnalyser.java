package com.bl.moodanalyser;
//This class is used for Analyse Mood
public class MoodAnalyser {
    //Declare variable
    private String message;
    public enum ErrorType  {
        NullError, EmptyError;
    }
    //Default constructor
    public MoodAnalyser() { }
    /*
    contains(): It is used to check string contain another substring or not.
    isEmpty() : It is used to check string is Empty or not
    Enum : It represent a group of named constants
    throw : Ti is used to explicitly throw an exception from a method or any block of code.
    String.valueOf() :Convert into string
    */

    //Parametrized constructor with string and initialized message according
    public MoodAnalyser(String message)
    {
        this.message=message;
    }
    //This Method analyze the content of a string msg and return message.
    public String analyseMood(String msg)
    {
        /*Only string with any mood should go inside only, bcoz we are comparing msg.contain()
        and if the string is null or empty & we check it contain direct then it will through exception NPE*/

        if (message != null && message != "") // Check String should not be null/Empty
        {
            if (message.contains("Sad")) // Check String with substring "SAD"
                this.message = "SAD";
            else
                this.message = "HAPPY"; // For any mood Happy msg
        }
        return message;
    }
    //This Method analyze the content of a string msg and return message.
    public String analyseMood()
    {
        try{
            analyseMood(message);
            if(message==null)
                throw new MoodAnalysisException(ErrorType.NullError);
            else if(message.isEmpty())
                throw new MoodAnalysisException(ErrorType.EmptyError);
            return  message;
        }
        catch(MoodAnalysisException e) {
            return e.getMessage();
        }
    }

}
