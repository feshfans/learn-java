package com.kang.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;

import javax.validation.constraints.NotNull;

/**
 * Created by kang on 16-5-14.
 */
public class SampleClassProxy {

    public static void main(String[] args) {
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "Hello Cglib";
            }
        });


        SampleClass proxy=(SampleClass)enhancer.create();
        System.out.println(proxy.test(null));
    }
}