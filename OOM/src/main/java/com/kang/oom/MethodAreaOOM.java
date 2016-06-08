package com.kang.oom;

/**
 * Created by kang on 16-6-4.
 */


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 方法区用于存放Class的相关信息,如类名、访问修饰符、常量池、字段描述、方法描述等
 * 对于这些区域的测试,基本思路是运行时产生大量的类去填满方法区,直到溢出。
 *
 * 借助CGLIB直接操作字节码运行时生成大量的动态类(JDK1.7及之前)
 *
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class MethodAreaOOM {

    public static void main(final String[] args) {

        while (true){
            Enhancer enhancer=new Enhancer();
            enhancer.setSuperclass(OOMOject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invoke(o,args);
                }
            });

            enhancer.create();

        }
    }

    static class OOMOject{

    }

}
