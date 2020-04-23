package com.bl.moodanalyser;
//This class is used for Analyse Mood
public class MoodAnalyser {
    //Declare variable
    private String message;
    //Default constructor
    public MoodAnalyser()
    {
        this.message=null;
    }
    //contains(): It is used to check string contain another substring or not.	
    //Parametrized constructor with string and initialized message according
    public MoodAnalyser(String message)
    {
        if(message.contains("Sad"))
            this.message="SAD";
        else if(message.contains("Happy"))
            this.message="HAPPY";
        else
            this.message="Plz enter valid string msg.";
    }
    //This Method return message.
    public String analyseMood()
    {
        return this.message;
    }
}
