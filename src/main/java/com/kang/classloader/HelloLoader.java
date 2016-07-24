package com.kang.classloader;

/**
 * Created by kang on 16-6-11.
 *
 * 此类有两个版本,一个放在应用中,一个放在/tmp/clz/下
 */
public class HelloLoader {

    public void print(){
        System.out.println("I am in app classloader");
        //System.out.println("I am in boot classloader");
    }
}
