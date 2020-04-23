package com.bl.moodanalyser;
//This class is used for Analyse Mood
public class MoodAnalyser {

    //contains(): It is used to check string contain another substring or not.
    //This Method analyze the content of a string msg and return Happy or Sad.
    public String analyseMood(String message)
    {
        if(message.contains("Happy"))
            return "HAPPY";
        else if(message.contains("Sad"))
            return "SAD";
        else
            return "Plz enter the valid msg.";
    }
}
