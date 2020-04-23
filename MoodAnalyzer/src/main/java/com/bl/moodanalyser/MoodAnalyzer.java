package com.bl.moodanalyser;

import com.bl.exception.MoodAnalyzerException;

public class MoodAnalyzer{
    public String checkForMood(String msg) throws MoodAnalyzerException {
        try {
            if (msg.contains("Happy")) {
                return "Happy";
            }
            else if (msg.isEmpty())
            {
                throw new MoodAnalyzerException("Plz enter the valid msg");
            }
            else {
                return "Sad";
            }
        } catch (NullPointerException exception) {
            throw new MoodAnalyzerException("Plz enter the valid mood");
        }
    }

}
