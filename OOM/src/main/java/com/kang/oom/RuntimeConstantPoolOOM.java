package com.kang.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kang on 16-6-4.
 */

/**
 * 在jdk1.6之前,由于常量池分配在永久代中,
 * 可通过-XX:PermSize 和-XX:MaxPermSize限制方法区大小
 *
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class RuntimeConstantPoolOOM {


    public static void main(String[] args) {
        //使用List保持着常量池的引用,避免Full GC回收常量池的行为
        List<String> list=new ArrayList<String>();

        for(int i=0;i<Integer.MAX_VALUE;i++){
            list.add(String.valueOf(i).intern());
        }
    }


}
