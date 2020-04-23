package com.bl.moodanalyser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//Test class for MoodAnalyser class
public class MoodAnalyserTest {

    //declare object/variable
    private MoodAnalyser moodAnalyser;
    private String message;

    //@Test :It indicate this is a test method.
    //Test method with sad substring in the msg
    @Test
    public void givenStringToConstructor_ContainSad_ShouldReturnSad()
    {
        message="I am in Sad Mood";
        moodAnalyser=new MoodAnalyser(message);
        Assert.assertEquals("SAD",moodAnalyser.analyseMood());
    }
    //Test method with happy substring in the msg
    @Test
    public void givenString_ContainHappy_ShouldReturnHappy()
    {
        message = "I am in Happy Mood";
        moodAnalyser=new MoodAnalyser(message);
        Assert.assertEquals("HAPPY", moodAnalyser.analyseMood());
    }
    //Test method to invoke constructor with improper string
    @Test
    public void givenStringToConstructor_WhenImproper_ShouldReturnMsg()
    {
        message = "I am in Fun Mood";
        moodAnalyser=new MoodAnalyser(message);
        Assert.assertEquals("Plz enter the valid msg.", moodAnalyser.analyseMood());
    }
    //Test method to invoke constructor with Null in string
    @Test
    public void givenNullToConstructor_ShouldReturnHappy()
    {
        message = null;
        moodAnalyser=new MoodAnalyser(message);
        Assert.assertEquals("Happy", moodAnalyser.analyseMood());
    }
}
