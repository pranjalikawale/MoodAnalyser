package com.bl.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

//Test class for MoodAnalyser class
public class MoodAnalyserTest {

    //declare object/variable
    private MoodAnalyser moodAnalyser;
    private String message;

    //@Test :It indicate this is a test method.
    //Test method with sad substring in the msg
    @Test
    public void givenMoodToMethod_ContainSad_ShouldReturnSad() throws MoodAnalysisException {
        message="I am in Sad Mood";
        moodAnalyser=new MoodAnalyser();
        Assert.assertEquals("SAD",moodAnalyser.analyseMood(message));
    }

    //Test method with happy substring in the msg
    @Test
    public void givenMoodToMethod_ContainHappy_ShouldReturnHappy() throws MoodAnalysisException {
        message = "I am in Happy Mood";
        moodAnalyser=new MoodAnalyser();
        Assert.assertEquals("HAPPY", moodAnalyser.analyseMood(message));
    }

    //Test method with sad substring in the msg
    @Test
    public void givenMood_ContainSad_ShouldReturnSad()
    {
        message="I am in Sad Mood";
        moodAnalyser=new MoodAnalyser(message);
        Assert.assertEquals("SAD",moodAnalyser.analyseMood());
    }

    //Test method with happy substring in the msg
    @Test
    public void givenMood_ContainHappy_ShouldReturnHappy()
    {
        message = "I am in Happy Mood";
        moodAnalyser=new MoodAnalyser(message);
        Assert.assertEquals("HAPPY", moodAnalyser.analyseMood());
    }

    //Test method to invoke constructor with any mood string
    @Test
    public void givenMood_WhenAnyMood_ShouldReturnHappy()
    {
        message = "I am in Fun Mood";
        moodAnalyser=new MoodAnalyser(message);
        Assert.assertEquals("HAPPY", moodAnalyser.analyseMood());
    }

    //Test method to invoke constructor with Empty string
    @Test
    public void givenEmptyToConstructor_ShouldReturnEmptyError()
    {
        message = "";
        moodAnalyser=new MoodAnalyser(message);
        Assert.assertEquals("EmptyError", moodAnalyser.analyseMood());
    }

    //Test method to invoke constructor with Null string
    @Test
    public void givenNullToConstructor_ShouldReturnNullError()
    {
        message = null;
        moodAnalyser=new MoodAnalyser(message);
        Assert.assertEquals("NullError", moodAnalyser.analyseMood());
    }

    //Test method to invoke default constructor without any msg
    @Test
    public void invokeDefaultConstructor_ShouldReturnNullError() throws MoodAnalysisException {
        moodAnalyser = new MoodAnalyser();
        Assert.assertEquals("NullError", moodAnalyser.analyseMood());
    }

}
