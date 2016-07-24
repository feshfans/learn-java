package com.kang.concurrent.cache;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by kang on 1 6-6-10.
 *
 * 真正高并发无Bug的缓存
 * 相比Memorizer2:
 * 1. 缓存类型发生改变,用FutureTask<V> 代替V
 * 2. Compute()改动
 *
 */
public class Memorizer<A,V> implements Computable<A,V> {

    //value用FutureTask类型来替换
    private final ConcurrentHashMap<A,FutureTask<V>> cache=new ConcurrentHashMap<A, FutureTask<V>>();

    private final Computable<A,V> c;

    public Memorizer(Computable<A,V> c){
        this.c=c;
    }

    @Override
    public V compute(final A arg) {

        FutureTask<V> v= cache.get(arg);
        if(v==null){
            Callable<V> callable=new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compute(arg);
                }
            };

            FutureTask<V> ft=new FutureTask<V>(callable);

            //此操作为原子性
            v= cache.putIfAbsent(arg,ft);

            //当之前缓存中没有时,执行任务
            if(v==null){
                v=ft;
                ft.run();
            }

        }

        try {
            //获取结果,当一个线程仍在执行计算时,别一个线程会在此阻塞直到计算完成.
            V value= v.get();
            return value;
        } catch (InterruptedException e) {
            cache.remove(arg);
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();

        }
        return null;
    }
}
