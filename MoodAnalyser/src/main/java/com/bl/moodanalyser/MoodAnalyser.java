package com.bl.moodanalyser;
//This class is used for Analyse Mood
public class MoodAnalyser {
        /*
    contains(): It is used to check string contain another substring or not.
    isEmpty() : It is used to check string is Empty or not
    Enum : It represent a group of named constants
    throw : Ti is used to explicitly throw an exception from a method or any block of code.
    String.valueOf() :Convert into string
    */

    //Declare variable
    private String message;
    public enum ErrorType  {
        NullError, EmptyError;
    }
    //Default constructor
    public MoodAnalyser() { }

    //Parametrized constructor with stridng and initialized message according
    public MoodAnalyser(String message)
    {
        this.message=message;
    }

    //This Method analyze the content of a string msg and return message.
    public String analyseMood(String msg) throws MoodAnalysisException {
        /*When String is null & we check null.Contain() then it will through exception NPE*/
        try{
            if(msg.isEmpty())
                throw new MoodAnalysisException(ErrorType.EmptyError);
            else if(msg.contains("Sad")) // Check String with substring "SAD"
                this.message = "SAD";
            else
                this.message = "HAPPY"; // For any mood Happy msg
        }catch (NullPointerException e){
            throw new MoodAnalysisException(ErrorType.NullError);
        }
        return message;
    }
    //This Method analyze the content of a string msg and specify the type of Exception.
    public String analyseMood()
    {
        try{
            analyseMood(message);
            return  message;
        }
        catch(MoodAnalysisException e) {
            return e.getMessage();
        }
    }
}
