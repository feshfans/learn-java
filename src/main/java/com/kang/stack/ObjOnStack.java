package com.kang.stack;

/**
 * Created by kang on 16-6-5.
 */

/**
 * 本类用来测试-栈上分配
 *
 * -server -Xms10m -Xmx10m -XX:+DoEscapeAnalysis
 * -XX:+PrintGC -XX:-UseTLAB -XX:+EliminateAllocations
 *
 * 如果未被优化,User对象累计占用的空间将近1.5G,势必会造成大量的GC.
 * 而程序打印结果,没有任何形式的GC输出,说明User对象的分配过程被优化.
 */
public class ObjOnStack {

    private static class User{

        public int id=0;
        public String name="";
    }

    public static void alloc(){
        User user=new User();
        user.id=5;
        user.name="kang";
    }

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        for(int i=0;i<100000000;i++){
            alloc();
        }
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
        while (true){

        }
    }
}
