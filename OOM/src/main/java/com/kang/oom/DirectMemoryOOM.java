package com.kang.oom;

/**
 * Created by kang on 16-6-4.
 */

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * DirectMemory 可以通过-XX:MaxDirectMemorySize指定,如果不指定,则默认与Java堆最大值(-Xmx)一样
 *
 * 代码通过反射获取Unsafe实例进行内存分配
 *
 *  由DirectMemory导致的内存溢出,一个明显的特征是在Head Dump 文件中不会看到明显的异常,
 *  如果发现OOM之后的Dump文件很小,而程序中又直接或间接使用了NIO,可以考虑检查一下这方面的原因
 *
 *  下面一运行linux系统就无法响应了
 */
public class DirectMemoryOOM {


    private static final int _1MB=1024*1024;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Field unsafeField= Unsafe.class.getDeclaredField("theUnsafe");
        unsafeField.setAccessible(true);

        Unsafe unsafe=(Unsafe) unsafeField.get(null);

        while (true){
            unsafe.allocateMemory(_1MB);
        }
    }

}
