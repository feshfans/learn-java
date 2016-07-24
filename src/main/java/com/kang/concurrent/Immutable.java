package com.kang.concurrent;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kang on 16-6-10.
 */

//防止子类改变状态
public final class Immutable {

    private final Set<String> store=new HashSet<String>();

    //仅有构建函数控制着对象状态
    public Immutable(){
        store.add("kang");
        store.add("hui");
        store.add("lai");
    }
    //并发读是没有任何问题的
    public boolean isExist(String name){
        return store.contains(name);
    }

}
