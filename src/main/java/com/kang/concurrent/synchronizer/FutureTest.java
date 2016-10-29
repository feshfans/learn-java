package com.kang.concurrent.synchronizer;

import java.util.concurrent.*;

/**
 * Created by feshfans on 2016/10/20.
 *
 * @email feshfans@163.com
 */
public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service= Executors.newFixedThreadPool(4);
        Future<String> result= service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.currentThread().sleep(10000);
                return "kang";
            }
        });

        Future<Integer> iResult= service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                return 123;
            }
        });
        System.out.println(iResult.get());
        System.out.println(result.get());

        service.shutdown();
    }
}
