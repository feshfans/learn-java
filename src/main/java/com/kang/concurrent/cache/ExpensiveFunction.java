package com.kang.concurrent.cache;

/**
 * Created by kang on 16-6-10.
 */
public class ExpensiveFunction implements Computable<String,Integer> {

    @Override
    public Integer compute(String arg) {
        //after deep thougt....
        System.out.println("正在计算"+arg+" ......");
        return Integer.valueOf(arg);
    }
}

/*
class Test<A,V> implements Computable<A,V>{

    @Override
    public V compute(A arg) {
        return null;
    }

}
*/
