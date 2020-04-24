package com.bl.moodanalyser;

public class MoodAnalysisException extends Exception  {

    public  MoodAnalysisException(MoodAnalyser.ErrorType errType){
        super(String.valueOf(errType));

    }
}
