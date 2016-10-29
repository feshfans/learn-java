package com.kang.test;

import com.kang.annotation.ParamDemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by feshfans on 2016/10/29.
 */
public class ParamDemoTest {
    public static void main(String[] args) {
        @ParamDemo String a="str";
        Method[] methods= ParamDemo.class.getDeclaredMethods();

        for(Method method:methods){
            Annotation[][] annotations= method.getParameterAnnotations();
        }
    }
}
