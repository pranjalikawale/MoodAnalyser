package com.bl.moodanalyser;

import com.bl.exception.MoodAnalyzerException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoodAnalyzerTest extends Exception {
    private MoodAnalyzer moodAnalyzer;

    @Before
    public void initialize() {
        moodAnalyzer = new MoodAnalyzer();
    }

    @Test
    public void givenString_WhenHappy_ShouldReturnHappy() {
        try {
            Assert.assertEquals("Happy", moodAnalyzer.checkForMood("I am Happy"));
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenString_WhenSad_ShouldReturnSad() {
        try {
            Assert.assertEquals("Sad", moodAnalyzer.checkForMood("I am Sad"));
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenNull_WhenNull_ShouldReturnMsg() {
        //  moodAnalyzer = new MoodAnalyzer(null);
        try {
            //ExceptedException exceptionRule = new ExceptedException.none();
            ///exceptionRule.expected(MoodAnalyzerException.class);
            String mood = moodAnalyzer.checkForMood(null);
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals("Plz enter the valid mood", e.getMessage());
        }

    }

    @Test
    public void givenEmpty_WhenEmpty_ShouldReturnMsg() {                                                                                                                       //  moodAnalyzer = new MoodAnalyzer(null);
        try {
            //ExceptedException exceptionRule = new ExceptedException.none();
            ///exceptionRule.expected(MoodAnalyzerException.class);
            moodAnalyzer.checkForMood("");
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals("Plz enter the valid msg", e.getMessage());
        }
    }
}