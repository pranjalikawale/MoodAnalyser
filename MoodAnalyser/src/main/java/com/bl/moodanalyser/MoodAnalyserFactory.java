package com.bl.moodanalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyser createMoodAnalyser(String className) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyserClass = Class.forName(className);
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
            Class<?> moodAnalyserClass = Class.forName(path);
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

    public static Object invokeMethod(Object moodAnalyserFactoryObj, String method) throws MoodAnalysisException {
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
}

