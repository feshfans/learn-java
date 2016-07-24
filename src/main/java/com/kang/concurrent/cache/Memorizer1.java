package com.kang.concurrent.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kang on 16-6-10.
 *
 * 缺点:
 * 1. 一次只能有一个线程执行compute()
 * 如果一个线程正在忙于计算结果,其他调用compute的线程可能被阻塞很长时间
 *
 */
public class Memorizer1<A,V> implements Computable<A,V> {

    private final Map<A,V> cache=new HashMap<A, V>();

    private final Computable<A,V> c;

    public Memorizer1(Computable<A,V> c){
        this.c=c;
    }

    @Override
    public V compute(A arg) {
        synchronized (this){
            V v= cache.get(arg);
            if(v==null){
                v=c.compute(arg);
                cache.put(arg,v);
            }
            return v;
        }
    }

}
