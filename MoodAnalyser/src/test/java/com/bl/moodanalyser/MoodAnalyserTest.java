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
        moodAnalyser=new MoodAnalyser("");
        Assert.assertEquals("EmptyError", moodAnalyser.analyseMood());
    }

    //Test method to invoke constructor with Null string
    @Test
    public void givenNullToConstructor_ShouldReturnNullError()
    {
        moodAnalyser=new MoodAnalyser(null);
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
    public void givenMoodAnalyserClassToDefaultConstructor_ShouldReturnObject_ThenCheckForEqualityOfObject() throws MoodAnalysisException {
        MoodAnalyser moodAnalyserFactory= MoodAnalyserFactory.createMoodAnalyser("com.bl.moodanalyser.MoodAnalyser");
        Assert.assertEquals(true,new MoodAnalyser().equals(moodAnalyserFactory));
    }
    //Test for handle class not found exception
    @Test
    public void givenMoodAnalyserClassToDefaultConstructor_WhenImproper_ShouldThrowClassNotFoundException() throws MoodAnalysisException {
        try {
            MoodAnalyser moodAnalyserFactory = MoodAnalyserFactory.createMoodAnalyser("com.bl.moodanalyser.MoodAnalyser12");
        }
        catch(MoodAnalysisException e)
        {
            Assert.assertEquals("NoSuchClassError", e.getMessage());
        }
    }
    //Test method to check equality of object using parameterized
    @Test
    public void givenMoodAnalyserClassToParameterizeConstructor_ShouldReturnObject_CheckForEqualityOfObject() throws MoodAnalysisException {
        MoodAnalyser moodAnalyserFactory = MoodAnalyserFactory.createMoodAnalyser("com.bl.moodanalyser.MoodAnalyser","I am in a Happy mood",String.class);
        Assert.assertEquals(true,new MoodAnalyser("I am in a Happy mood").equals(moodAnalyserFactory));
    }
    //Test method to handle class not found using parameterize
    @Test
    public void givenMoodAnalyserClassToParameterizeConstructor_WhenImproper_ShouldThrowClassNotFoundException() throws MoodAnalysisException {
        try {
            MoodAnalyser moodAnalyserFactory = MoodAnalyserFactory.createMoodAnalyser("com.bl.moodanalyser.MoodAnalyser12","I am in a Happy mood",String.class);
        }
        catch(MoodAnalysisException e)
        {
            Assert.assertEquals("NoSuchClassError", e.getMessage());
        }
    }
    //Test method to handle class not found using parameterize
    @Test
    public void givenMoodAnalyserClassToParameterizeConstructor_WhenImproper_ShouldThrowMethodNotFoundException() throws MoodAnalysisException {
        try {
            MoodAnalyser moodAnalyserFactory = MoodAnalyserFactory.createMoodAnalyser("com.bl.moodanalyser.MoodAnalyser","I am in a Happy mood",Integer.class);
        }
        catch(MoodAnalysisException e)
        {
            Assert.assertEquals("NoSuchMethodError", e.getMessage());
        }
    }
    //Test method to invoke method when msg happy should return happy
    @Test
    public void givenHappyMessage_WhenProper_ShouldReturnHappyMood() throws MoodAnalysisException {
            MoodAnalyser moodAnalyserFactory = MoodAnalyserFactory.createMoodAnalyser("com.bl.moodanalyser.MoodAnalyser","I am in a Happy mood",String.class);
            Assert.assertEquals("HAPPY",MoodAnalyserFactory.invokeMethod(moodAnalyserFactory,"analyseMood"));
    }
    //Test method for invoke wrong method should handle method not found exception
    @Test
    public void givenHappyMessage_WhenMethodImproper_ShouldShouldThrowMethodNotFoundException() throws MoodAnalysisException {
        try {
            MoodAnalyser moodAnalyserFactory = MoodAnalyserFactory.createMoodAnalyser("com.bl.moodanalyser.MoodAnalyser","I am in a Happy mood",String.class);
            Assert.assertEquals("HAPPY",MoodAnalyserFactory.invokeMethod(moodAnalyserFactory,"analyseMood1"));
        }
        catch(MoodAnalysisException e)
        {
            e.printStackTrace();
        }
    }
    //Test method for set field
    @Test
    public void givenHappyMessage_SetField_ShouldReturnHappy() throws MoodAnalysisException {
            MoodAnalyser moodAnalyserFactory = MoodAnalyserFactory.createMoodAnalyser("com.bl.moodanalyser.MoodAnalyser","I am in a Sad mood",String.class);
            Assert.assertEquals("HAPPY",MoodAnalyserFactory.invokeMethod((MoodAnalyser)MoodAnalyserFactory.setFieldDynamically(moodAnalyserFactory,"message","I am in a Happy mood"),"analyseMood"));
    }
    //Test method for set invalid field and handle exception
    @Test
    public void givenHappyMessage_SetField_WhenImproper_ShouldHandleFieldNotFoundException() throws MoodAnalysisException {
        try {
            MoodAnalyser moodAnalyserFactory = MoodAnalyserFactory.createMoodAnalyser("com.bl.moodanalyser.MoodAnalyser","I am in a Sad mood",String.class);
            MoodAnalyserFactory.invokeMethod((MoodAnalyser)MoodAnalyserFactory.setFieldDynamically(moodAnalyserFactory,"message1","I am in a Happy mood"),"analyseMood");
        }
        catch(MoodAnalysisException e) {
            Assert.assertEquals("NoSuchFieldError", e.getMessage());
        }
    }
    //Test method for set invalid field and handle exception
    @Test
    public void givenNullMessage_SetField_WhenImproper_ShouldHandleNullException() throws MoodAnalysisException {
        try {
            MoodAnalyser moodAnalyserFactory = MoodAnalyserFactory.createMoodAnalyser("com.bl.moodanalyser.MoodAnalyser", "I am in a Sad mood", String.class);
            MoodAnalyserFactory.invokeMethod((MoodAnalyser)MoodAnalyserFactory.setFieldDynamically(moodAnalyserFactory,"message",null),"analyseMood");
        }catch(MoodAnalysisException e) {
            Assert.assertEquals("NullError", e.getMessage());
        }
    }
}
