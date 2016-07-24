package com.kang.concurrent.cache;

import java.util.Random;

/**
 * Created by kang on 16-6-10.
 *
 *   正在计算4 ......
     result : 4
     result : 4
     正在计算0 ......
     result : 0
     正在计算2 ......
     result : 0
     正在计算3 ......
     result : 3
     result : 4
     result : 2
     result : 2
     result : 2
     正在计算1 ......
     result : 1
 *
 */
public class Client {

    public static void main(String[] args) {

        final Random random=new Random();

        final Memorizer<String,Integer> cache=new Memorizer<String, Integer>(new ExpensiveFunction());

        for(int i=0;i<10;i++){
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {
                    Integer result= cache.compute(String.valueOf(random.nextInt(5)));
                    System.out.println("result : "+result);
                }
            });
            t.start();
        }
    }
}
