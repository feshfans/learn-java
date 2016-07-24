package com.kang.concurrent.synchronizer;

/**
 * Created by kang on 16-6-10.
 */

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * 利用信号量将容器转化为有界的阻塞容器
 *
 */
public class SemaphoreDemo<T> {

    private final Set<T> set;
    private final Semaphore semaphore;
    public SemaphoreDemo(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<T>());
        this.semaphore = new Semaphore(bound);
    }

    public boolean add(T t) throws InterruptedException {
        semaphore.acquire();
        boolean isAdd=false;
        try{
            isAdd=set.add(t);
            System.out.println(t+" is added");
            return isAdd;
        }finally {
            if(!isAdd){
                semaphore.release();
            }
        }
    }

    public boolean remove(Object o){
        boolean isRemoved=set.remove(o);
        if(isRemoved){
            semaphore.release();
            System.out.println(o+" is removed");
        }

        return isRemoved;
    }

    public static void main(String[] args) throws InterruptedException {
        final SemaphoreDemo<Integer> demo=new SemaphoreDemo<Integer>(5);

        for(int i=0;i<6;i++){
            final Integer value=Integer.valueOf(i);
            Thread t=new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        demo.add(value);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }

        //demo.remove(2);
        demo.remove(3);
    }
}
