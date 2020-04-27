package com.bl.moodanalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static Class getClassPath(String path) throws ClassNotFoundException {
        return Class.forName(path);
    }
    public static MoodAnalyser createMoodAnalyser(String path) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyserClass = getClassPath(path);
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor();
            return (MoodAnalyser) moodConstructor.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalyser.ErrorType.NoSuchClassError);
        }
        return null;
    }

    public static MoodAnalyser createMoodAnalyser(String path, String message, Class className) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyserClass = getClassPath(path);
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(className);
            return (MoodAnalyser) moodConstructor.newInstance(message);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalyser.ErrorType.NoSuchMethodError);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalyser.ErrorType.NoSuchClassError);
        }
        return null;
    }

    public static Object invokeMethod(MoodAnalyser moodAnalyserFactoryObj, String method) throws MoodAnalysisException {
        try {
            return moodAnalyserFactoryObj.getClass().getMethod(method).invoke(moodAnalyserFactoryObj);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalyser.ErrorType.NoSuchMethodError);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    return null;
    }

    public static Object setFieldDynamically(MoodAnalyser moodAnalyserFactoryObj,String fieldName,String mood) throws MoodAnalysisException {
        try{
            Field field=moodAnalyserFactoryObj.getClass().getField(fieldName);
            field.setAccessible(true);
            field.set(moodAnalyserFactoryObj,mood);
            return moodAnalyserFactoryObj;
        }
        catch (NoSuchFieldException e ) {
            throw new MoodAnalysisException(MoodAnalyser.ErrorType.NoSuchFieldError);
        }catch (NullPointerException e){
            throw new MoodAnalysisException(MoodAnalyser.ErrorType.NullError);
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        return null;
    }

}



