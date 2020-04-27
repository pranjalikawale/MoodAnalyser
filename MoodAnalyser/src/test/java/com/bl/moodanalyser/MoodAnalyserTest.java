package com.bl.moodanalyser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


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
    //Test method to check equality of object
    @Test
    public void givenMoodAnalyserClassToDefaultConstructor_ShouldReturnObject_CheckForEqualityOfObject() throws MoodAnalysisException {
        MoodAnalyser moodAnalyserFactory= MoodAnalyserFactory.createMoodAnalyser("com.bl.moodanalyser.MoodAnalyser");
        Assert.assertEquals(true,new MoodAnalyser().equals(moodAnalyserFactory));
    }
    //Test for handle class not found exception
    @Test
    public void givenMoodAnalyserClassToDefaultConstructor_WhenImproper_ShouldThrowClassNotFoundException() throws MoodAnalysisException {
        try {
            MoodAnalyser moodAnalyserFactory = MoodAnalyserFactory.createMoodAnalyser("com.bl.moodanalyser.MoodAnalyser12");
        }
        catch(Exception e)
        {
            Assert.assertEquals("NoSuchClassError", e.getMessage());
        }
    }
    //Test method to check equality of object using parameterized
    @Test
    public void givenMoodAnalyserClassToParameterizeConstructor_ShouldReturnObject_CheckForEqualityOfObject() throws MoodAnalysisException {
        MoodAnalyser moodAnalyserFactory = MoodAnalyserFactory.createMoodAnalyser("com.bl.moodanalyser.MoodAnalyser","I am in a Happy mood");
        Assert.assertEquals(true,new MoodAnalyser("I am in a Happy mood").equals(moodAnalyserFactory));
    }
    //Test method to handle class not found using parameterize
    @Test
    public void givenMoodAnalyserClassToParameterizeConstructor_WhenImproper_ShouldThrowClassNotFoundException() throws MoodAnalysisException {
        try {
            MoodAnalyser moodAnalyserFactory = MoodAnalyserFactory.createMoodAnalyser("com.bl.moodanalyser.MoodAnalyser12","I am in a Happy mood");
        }
        catch(Exception e)
        {
            Assert.assertEquals("NoSuchClassError", e.getMessage());
        }
    }
    
}
