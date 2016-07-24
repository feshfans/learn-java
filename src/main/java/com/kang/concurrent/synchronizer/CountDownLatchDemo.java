package com.kang.concurrent.synchronizer;

import java.util.concurrent.CountDownLatch;

/**
 * Created by kang on 16-6-10.
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo demo=new CountDownLatchDemo();
        demo.timeTasks(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("===============");
            }
        });
    }

    public long timeTasks(int nThreads,final Runnable task) throws InterruptedException {
        final CountDownLatch startGate=new CountDownLatch(1);
        final CountDownLatch endGate=new CountDownLatch(nThreads);

        for(int i=0;i<nThreads;i++){
            Thread t=new Thread(){
                @Override
                public void run() {
                    try {
                        //线程等待
                        startGate.await();
                        try {
                            task.run();
                        }finally {
                            endGate.countDown();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }

        Thread.sleep(5000);
        long start=System.nanoTime();
        //计数减1,触发上面等待的线程运行
        startGate.countDown();
        //主线程进入等待,直到上面的子线程执行完
        endGate.await();
        long end=System.nanoTime();
        return start-end;

    }
}
