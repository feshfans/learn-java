package com.kang.concurrent.synchronizer;

/**
 * Created by kang on 16-6-10.
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 使用FutureTask来预执行比较耗时的工作,这个平时用处很大
 */
public class PreLoader {

    private final FutureTask<Integer> futureTask=new FutureTask<Integer>(new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(5000);
            return 5;
        }
    });

    private final Thread thread=new Thread(futureTask);

    public void start(){
        thread.start();
        //如果直接run,其实是一个同步的线程
        //futureTask.run();
    }

    public Integer get(){
        try {
            return futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) throws InterruptedException {
        PreLoader loader=new PreLoader();
        loader.start();
        Thread.sleep(3000);
        System.out.println("===========");
        System.out.println(loader.get());
    }
}
