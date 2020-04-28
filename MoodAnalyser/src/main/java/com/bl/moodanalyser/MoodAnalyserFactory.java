package com.bl.moodanalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    //return class path
    public static Class getClassPath(String path) throws ClassNotFoundException {
        return Class.forName(path);
    }
    //return object
   public static MoodAnalyser createMoodAnalyser(String path) throws MoodAnalysisException {
       MoodAnalyser object=null;
        try {
            Class<?> moodAnalyserClass = getClassPath(path);
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor();
            object = (MoodAnalyser) moodConstructor.newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException  e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalyser.ErrorType.NoSuchMethodError);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalyser.ErrorType.NoSuchClassError);
        }
        return object;
    }
    //return object by invoking parameterized constructor
    public static MoodAnalyser createMoodAnalyser(String path, String message, Class className) throws MoodAnalysisException {
        MoodAnalyser object=null;
        try {
            Class<?> moodAnalyserClass = getClassPath(path);
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(className);
            object = (MoodAnalyser) moodConstructor.newInstance(message);
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalyser.ErrorType.NoSuchMethodError);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalyser.ErrorType.NoSuchClassError);
        }
        return object;
    }
    // invoke moodAnalyse method
    public static Object invokeMethod(MoodAnalyser moodAnalyserFactoryObj, String method) throws MoodAnalysisException {
        Object object=null;
        try {
            object = moodAnalyserFactoryObj.getClass().getMethod(method).invoke(moodAnalyserFactoryObj);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalyser.ErrorType.NoSuchMethodError);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    return object;
    }
    // set field
    public static MoodAnalyser setFieldDynamically(MoodAnalyser moodAnalyserFactoryObj,String fieldName,String mood) throws MoodAnalysisException {
        try{
            Field field=moodAnalyserFactoryObj.getClass().getField(fieldName);
            field.set(moodAnalyserFactoryObj,mood);
        }
        catch (NoSuchFieldException e ) {
            throw new MoodAnalysisException(MoodAnalyser.ErrorType.NoSuchFieldError);
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }
        return moodAnalyserFactoryObj;
    }

}



