package com.kang.simplefactory;

/**
 * Created by kang on 16-6-21.
 */
public class ImplB implements Api {
    @Override
    public void operation(String s) {
        System.out.println("ImplB : "+s);
    }
}
