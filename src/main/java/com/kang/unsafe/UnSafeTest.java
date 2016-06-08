package com.kang.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by kang on 16-5-21.
 */
public class UnSafeTest {

    private int i=0;
    public static void main(String[] args) {

        try {
            //只能被JDK信任的类实例化,所以下面的方法会报错
            //Unsafe unsafe=Unsafe.getUnsafe();
            //但事情总有解决办法,使用反射即可
            Field unsafeField=Unsafe.class.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);
            Unsafe unsafe=(Unsafe)unsafeField.get(null);
            long offset= unsafe.objectFieldOffset(UnSafeTest.class.getDeclaredField("i"));
            System.out.println(offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

