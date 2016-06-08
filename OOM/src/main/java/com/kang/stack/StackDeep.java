package com.kang.stack;

/**
 * Created by kang on 16-6-5.
 */

/**
 * -Xss512k
 */
public class StackDeep {

    private static int count=0;
    public static void fun1(long a,long b, long c){
        long e=1,f=2,g=3,h=4,i=5,j=6,k=7,l=8,m=9,n=10;
        count++;
        fun1(a,b,c);
    }

    public static void fun2(){
        count++;
        fun2();
    }

    public static void main(String[] args) {
        try {
            //fun1(1L,2L,3L);
            fun2();
        }catch (Throwable e){
            System.out.println("deep of calling = "+count);
            e.printStackTrace();
        }

    }
}
