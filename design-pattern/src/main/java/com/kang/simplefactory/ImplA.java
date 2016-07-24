package com.kang.simplefactory;

/**
 * Created by kang on 16-6-21.
 */
public class ImplA implements Api {
    @Override
    public void operation(String s) {
        System.out.println("ImplA : "+s);
    }
}
