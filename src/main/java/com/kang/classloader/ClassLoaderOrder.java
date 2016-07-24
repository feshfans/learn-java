package com.kang.classloader;

/**
 * Created by kang on 16-6-
 *
 * 测试类的加载顺序
 * 第一次：直接执行
 * 结果： I am in app classloader
 *
 * 第二次：加参数-Xbootclasspath/a:/tmp/clz
 *  结果：I am in boot classloader
 *
 */
public class ClassLoaderOrder {
    public static void main(String[] args) {
        HelloLoader loader=new HelloLoader();
        loader.print();
    }
}


