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
    //Parametrized constructor with string and initialized message according
    public MoodAnalyser(String message)
    {
        if(message.contains("Sad"))
            this.message="SAD";
        else
            new MoodAnalyser();

    }
    //contains(): It is used to check string contain another substring or not.
    //This Method analyze the content of a string msg and return Happy or Sad.
    public String analyseMood()
    {
        return this.message;
    }
}
