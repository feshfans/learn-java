package com.kang.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kang on 16-6-3.
 */

/**
 * 堆内存溢出，有可能以下两种情况：
 * 1. 内存泄漏
 * 2. 堆内存确实太小
 *
 * 对于1,要确认内存中的对象是否是必要的
 *
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<OOMObject>();
        while (true){
            try{
                list.add(new OOMObject());
            }catch (Throwable e){
                System.out.println(list.size());
            }

        }
    }
}
