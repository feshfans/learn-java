package com.kang.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by kang on 16-6-9.
 */
public class MyVector {
    public static void main(String[] args) {
        //Vector是线程安全的,是同步容器.但对于复合操作,有时需要客户端加锁进行保护
        Vector vector=new Vector();
        //线程非安全的
        Map map=new HashMap();

        Map synMap= Collections.synchronizedMap(new HashMap());

        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap(10);

    }
}
