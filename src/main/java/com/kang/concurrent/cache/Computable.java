package com.kang.concurrent.cache;

/**
 * Created by kang on 16-6-10.
 */
public interface Computable<A,V> {

    V compute(A arg);
}
