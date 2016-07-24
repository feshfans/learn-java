package com.kang.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URLClassLoader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created by kang on 16-6-11.
 *
 * 突破双亲委托
 * 重载loadClass()改变默认的双亲委托加载方式
 * 结果：
 * I can not load the class : java.lang.Object
 * com.kang.classloader.OrderClassLoader@6ff3c5b5
 *
 */
public class OrderClassLoader extends ClassLoader {

    private String fileName;

    public OrderClassLoader(String fileName){
        this.fileName=fileName;
    }
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {

        Class clz=findClass(name);
        if(clz==null){
            System.out.println("I can not load the class : "+name);
            return super.loadClass(name,resolve);
        }

        return clz;

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        Class clz=findLoadedClass(name);
        if(clz==null){
            String classFile=getClassFile(name);
            try {
                FileInputStream fis=new FileInputStream(classFile);

                FileChannel fileChannel=fis.getChannel();
                ByteArrayOutputStream baos=new ByteArrayOutputStream();
                WritableByteChannel wbc= Channels.newChannel(baos);

                ByteBuffer buffer= ByteBuffer.allocateDirect(1024);

                while (true){
                    int i=fileChannel.read(buffer);
                    if(i==0||i==-1){
                        break;
                    }
                    buffer.flip();
                    wbc.write(buffer);
                    buffer.clear();
                }

                fis.close();

                byte[] bytes=baos.toByteArray();

                clz=defineClass(name,bytes,0,bytes.length);
            } catch (FileNotFoundException e) {

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return clz;
    }

    private String getClassFile(String className){
        className=className.replace(".","/")+".class";

        return this.fileName.concat(className);
    }


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {

        ClassLoader classLoader=new OrderClassLoader("/tmp/clz/");

        //Thread.currentThread().setContextClassLoader(classLoader);

        Class clz= classLoader.loadClass("com.kang.classloader.HelloLoader");

        System.out.println(clz.getClassLoader());

        //转换异常,不在同一个类加载器中,是两种完全不同的类型
        /*HelloLoader loader=(HelloLoader) clz.newInstance();
        loader.print();
*/

        HelloLoader helloLoader=new HelloLoader();

        System.out.println(helloLoader.getClass().getClassLoader());

    }
}
