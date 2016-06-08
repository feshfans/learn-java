package com.kang.singleton;

import javax.validation.constraints.NotNull;

/**
 * Created by kang on 16-5-14.
 */
public class Singleton {

    private static Singleton singleton=new Singleton();

    private Singleton(){}

    public static Singleton getSingleton(){
        return singleton;
    }

}
