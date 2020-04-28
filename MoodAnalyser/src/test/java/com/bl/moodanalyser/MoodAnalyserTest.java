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
    private String mood="I am in a happy mood";
    private String methodName="analyseMood";
    private static final String path="com.bl.moodanalyser.MoodAnalyser";

    //@Before execute before all test method
    @Before
    public void initialize() {
        moodAnalyser=new MoodAnalyser();
    }

    //@Test :It indicate this is a test method.
    //Test method with sad substring in the msg
    @Test
    public void givenMoodToMethod_ContainSad_ShouldReturnSad() throws MoodAnalysisException {
        message="I am in Sad Mood";
        Assert.assertEquals("SAD",moodAnalyser.analyseMood(message));
    }

    //Test method with happy substring in the msg
    @Test
    public void givenMoodToMethod_ContainHappy_ShouldReturnHappy() throws MoodAnalysisException {
        Assert.assertEquals("HAPPY", moodAnalyser.analyseMood(mood));
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
        moodAnalyser=new MoodAnalyser(mood);
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
        //moodAnalyser = new MoodAnalyser();
        Assert.assertEquals("NullError", moodAnalyser.analyseMood());
    }

    //Test method to check equality of object
    @Test
    public void givenMoodAnalyserClassToDefaultConstructor_ShouldReturnObject_ThenCheckForEqualityOfObject()throws MoodAnalysisException  {
        MoodAnalyser moodAnalyserFactory= MoodAnalyserFactory.createMoodAnalyser(path);
        Assert.assertEquals(true,new MoodAnalyser().equals(moodAnalyserFactory));
    }

    //Test for handle class not found exception
    @Test
    public void givenMoodAnalyserClassToDefaultConstructor_WhenImproper_ShouldThrowClassNotFoundException() throws MoodAnalysisException {
        try {
            MoodAnalyser moodAnalyserFactory = MoodAnalyserFactory.createMoodAnalyser("com.bl.moodanalyser.MoodAnalyser12");
        }
        catch(MoodAnalysisException e) {
            Assert.assertEquals("NoSuchClassError", e.getMessage());
        }
    }

    //Test method to check equality of object using parameterized
    @Test
    public void givenMoodAnalyserClassToParameterizeConstructor_ShouldReturnObject_ThenCheckForEqualityOfObject() throws MoodAnalysisException {
        MoodAnalyser moodAnalyserFactory = MoodAnalyserFactory.createMoodAnalyser(path,mood,String.class);
        Assert.assertEquals(true,new MoodAnalyser(mood).equals(moodAnalyserFactory));
    }

    //Test method to handle class not found using parameterize
    @Test
    public void givenMoodAnalyserClassToParameterizeConstructor_WhenImproper_ShouldThrowClassNotFoundException() throws MoodAnalysisException {
        try {
            MoodAnalyser moodAnalyserFactory = MoodAnalyserFactory.createMoodAnalyser("com.bl.moodanalyser.MoodAnalyser12",mood,String.class);
        }
        catch(MoodAnalysisException e) {
            Assert.assertEquals("NoSuchClassError", e.getMessage());
        }
    }

    //Test method to handle class not found using parameterize
    @Test
    public void givenMoodAnalyserClassToParameterizeConstructor_WhenImproper_ShouldThrowMethodNotFoundException() throws MoodAnalysisException {
        try {
            MoodAnalyser moodAnalyserFactory = MoodAnalyserFactory.createMoodAnalyser(path,mood,Integer.class);
        }
        catch(MoodAnalysisException e) {
            Assert.assertEquals("NoSuchMethodError", e.getMessage());
        }
    }

    //Test method to invoke method when msg happy should return happy
    @Test
    public void givenHappyMessage_WhenMethodProper_ShouldReturnHappyMood() throws MoodAnalysisException {
        MoodAnalyser moodAnalyserFactory = MoodAnalyserFactory.createMoodAnalyser(path,mood,String.class);
        Assert.assertEquals("HAPPY",MoodAnalyserFactory.invokeMethod(moodAnalyserFactory,methodName));
    }

    //Test method for invoke wrong method should handle method not found exception
    @Test
    public void givenHappyMessage_WhenMethodImproper_ShouldShouldThrowMethodNotFoundException() throws MoodAnalysisException {
        try {
            MoodAnalyser moodAnalyserFactory = MoodAnalyserFactory.createMoodAnalyser(path,mood,String.class);
            MoodAnalyserFactory.invokeMethod(moodAnalyserFactory,"analyseMood1");
        }
        catch(MoodAnalysisException e)
        {
            Assert.assertEquals("NoSuchMethodError",e.getMessage());
        }
    }

    //Test method for set field
    @Test
    public void givenHappyMessage_SetField_WhenProper_ShouldReturnHappy() throws MoodAnalysisException {
        MoodAnalyser moodAnalyserFactory = MoodAnalyserFactory.createMoodAnalyser(path,"I am in a Sad mood",String.class);
        Assert.assertEquals("HAPPY",MoodAnalyserFactory.invokeMethod(MoodAnalyserFactory.setFieldDynamically(moodAnalyserFactory,"message",mood),methodName));
    }

    //Test method for set invalid field and handle exception
    @Test
    public void givenHappyMessage_SetField_WhenImproper_ShouldHandleFieldNotFoundException() throws MoodAnalysisException {
        try {
            MoodAnalyser moodAnalyserFactory = MoodAnalyserFactory.createMoodAnalyser(path,"I am in a Sad mood",String.class);
            MoodAnalyserFactory.invokeMethod(MoodAnalyserFactory.setFieldDynamically(moodAnalyserFactory,"message1",mood),methodName);
        }
        catch(MoodAnalysisException e) {
            Assert.assertEquals("NoSuchFieldError", e.getMessage());
        }
    }

    //Test method for set invalid field and handle exception
    @Test
    public void givenNullMessage_SetField_WhenImproper_ShouldHandleNullException() throws MoodAnalysisException {
        try {
            MoodAnalyser moodAnalyserFactory = MoodAnalyserFactory.createMoodAnalyser(path, mood, String.class);
            MoodAnalyserFactory.invokeMethod(MoodAnalyserFactory.setFieldDynamically(moodAnalyserFactory,"message",null),methodName);
        }catch(MoodAnalysisException e) {
            Assert.assertEquals("NullError", e.getMessage());
        }
    }
}
