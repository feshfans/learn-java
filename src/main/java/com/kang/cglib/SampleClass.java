package com.kang.cglib;

import org.junit.Test;

/**
 * Created by kang on 16-5-14.
 */

public class SampleClass {

    public String test(String input){
        return "Hello World";
    }

    public static void main(String[] args) {
        SampleClass sampleClass=new SampleClass();
        System.out.println(sampleClass.test(null));
    }
}
