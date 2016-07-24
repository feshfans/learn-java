package com.kang.simplefactory;

/**
 * Created by kang on 16-6-21.
 */
public class Client {

    public static void main(String[] args) {

        Api apiA=ApiFactory.createApi(0);
        apiA.operation("test");

        Api apiB=ApiFactory.createApi(1);
        apiB.operation("test");


    }
}
