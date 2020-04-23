package com.bl.moodanalyser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//Test class for MoodAnalyser class
public class MoodAnalyserTest {

    //declare object/variable
    private MoodAnalyser moodAnalyser;
    private String message;
    /*
     @Before : Method annotated with @before will execute before all test method run.
     @Test :It indicate this is a test method.
    */

    //Create instance of MoodAnalyser
    @Before
    public void initialized()
    {
        moodAnalyser=new MoodAnalyser();
    }
    //Test method with sad substring in the msg
    @Test
    public void givenString_ContainSad_ShouldReturnSad()
    {
        message="I am in Sad Mood";
        Assert.assertEquals("SAD",moodAnalyser.analyseMood(message));
    }
    //Test method with happy substring in the msg
    @Test
    public void givenString_ContainHappy_ShouldReturnHappy()
    {
        message = "I am in Happy Mood";
        Assert.assertEquals("HAPPY", moodAnalyser.analyseMood(message));
    }
    //Test method with improper string
    @Test
    public void givenString_WhenImproper_ShouldReturnMessage()
    {
        message = "I am in Fun Mood";
        Assert.assertEquals("Plz enter the valid msg.", moodAnalyser.analyseMood(message));
    }

}
