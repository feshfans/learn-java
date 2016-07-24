package com.kang.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by kang on 16-6-11.
 *
 * 测试查找类是否已加载的顺序
 * -Xbootclasspath/a:/tmp/clz
 *
 * 结果：
 * sun.misc.Launcher$AppClassLoader@266474c2
 * I am in boot classloader
 *
 */
public class FindClassOrder {

    public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ClassLoader cl=FindClassOrder.class.getClassLoader();

        //利用反射定义HelloLoader
        byte[] bytes=loadClassBytes("com.kang.classloader.HelloLoader");
        //byte[] bytes=loadClassBytes("HelloLoader");
        Method m_defineClass=ClassLoader.class.getDeclaredMethod("defineClass",byte[].class,int.class,int.class);

        m_defineClass.setAccessible(true);
        m_defineClass.invoke(cl,bytes,0,bytes.length);
        m_defineClass.setAccessible(false);

        HelloLoader loader=new HelloLoader();
        System.out.println(loader.getClass().getClassLoader());
        loader.print();
    }

    private static byte[] loadClassBytes(String name) throws IOException {

        name=name.replace(".","/")+".class";
        //System.out.println("name:"+name);
        //System.out.println(FindClassOrder.class.getResource("/").getPath());
        //System.out.println(FindClassOrder.class.getClassLoader().getResource(name).getPath());
        //System.out.println(ClassLoader.getSystemResource(name).getPath());

        InputStream in= ClassLoader.getSystemResourceAsStream(name);

        byte[] clzBytes=new byte[in.available()];

        int count= in.read(clzBytes);

        //System.out.println("count:"+count);

        return clzBytes;

    }
}
