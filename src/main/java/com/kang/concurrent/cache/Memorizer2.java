package com.kang.concurrent.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by kang on 16-6-10.
 */
public class Memorizer2<A,V> implements Computable<A,V> {

    //利用ConcurrentHashMap替换HashMap
    private final Map<A,V> cache=new ConcurrentHashMap<A, V>();

    private final Computable<A,V> c;

    public Memorizer2(Computable<A,V> c){
        this.c=c;
    }
    @Override
    public V compute(A arg) {

        //这仍然有漏洞,先检查再计算并不是原子性的
        //当一个线程启动了一个开销很大的线程,其它线程并不知道这个计算正在进行中,
        // 所以可能又会重新这个计算
        V v= cache.get(arg);
        if(v==null){
            v=c.compute(arg);
            cache.put(arg,v);
        }
        return v;
    }
}
