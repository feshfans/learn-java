package com.kang.simplefactory;

/**
 * Created by kang on 16-6-21.
 */
public class ApiFactory {

    //第一种方法
    public static Api createApi(int type){

        if(type==0){
            return new ImplA();
        }

        return new ImplB();

    }

    //第二种方式
    public static Api getApiA(){
        return new ImplA();
    }

    public static Api getApiB(){
        return new ImplB();
    }


    //第三种方式
    //实现类可配置,然后根据反射来实例化具体实现类
    //因为第一种方式和第二种方式新添加实现类时必须改动代码
    //但这种方式只适用于系统只会使用唯一的一个或有限的几个实现类
}
