package com.kang.oom;

/**
 * Created by kang on 16-6-3.
 */

/**
 *系统分配给进程的内存-Xmx-MaxPermSize-程序计数器消耗的内存(很小,可以忽略)-虚拟机进程本身耗费的内在(不计算在内)=剩余内存被栈内存瓜分
 * 每个线程分配到的栈容量越大,可以建立的线程数量自然就越少
 *
 * -Xss设置的是单个线程的栈内存
 */
public class VMStackOOM {

    private void  dontStop(){
        while (true){

        }
    }


    public void stackLeakByThread(){

        while (true){
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }


    public static void main(String[] args) {
        VMStackOOM vmStackOOM=new VMStackOOM();
        vmStackOOM.stackLeakByThread();
    }
}