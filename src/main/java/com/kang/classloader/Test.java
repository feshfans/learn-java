package com.kang.classloader;

import sun.reflect.Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by kang on 16-5-22.
 */
public class Test {
    public static void main(String[] args) {
        ClassLoader appClassLoader=Thread.currentThread().getContextClassLoader();
        System.out.println(appClassLoader);

        Thread.currentThread().setContextClassLoader(appClassLoader.getParent());
        System.out.println(appClassLoader.getParent());
        System.out.println(appClassLoader.getParent().getParent());
        //System.out.println(appClassLoader.getParent().getParent().getParent());
        System.out.println(Test.class.getClassLoader());

        try {
            Class cls= Class.forName("com.kang.classloader.Test");

            System.out.println(cls.getClassLoader());
            Method method= cls.getDeclaredMethod("test");
            String test=(String)method.invoke(cls.newInstance());


            System.out.println(test);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    private String test(){
        System.out.println("===============");
        return "test";
    }
}

