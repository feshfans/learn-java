package com.kang.concurrent.synchronizer;

import java.util.Random;
import java.util.RandomAccess;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by kang on 16-6-10.
 */
public class CyclicBarrierDemo {

    private final CyclicBarrier barrier;
    private final Worker[] workers;
    public CyclicBarrierDemo(int bound){
        barrier=new CyclicBarrier(bound, new Runnable() {
            @Override
            public void run() {

                System.out.println("所有线程执行完毕");
            }
        });

        workers=new Worker[bound];
        for(int i=0;i<bound;i++){
            workers[i]=new Worker();
        }
    }

    public void start(){
        for(int i=0;i<workers.length;i++){
            new Thread(workers[i]).start();
        }
    }
    private class Worker implements Runnable{

        @Override
        public void run() {
            try {
                //放在这,就可以让线程同时执行某些操作
                barrier.await();
                Thread.sleep(Math.abs(new Random().nextInt(5)*1000));
                System.out.println(Thread.currentThread().getName());
                //放在这,就可以等待所有线程都执行完毕
                //barrier.await();
            } catch (InterruptedException e) {
                return;
            } catch (BrokenBarrierException e) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        CyclicBarrierDemo demo=new CyclicBarrierDemo(5);
        demo.start();
    }
}
