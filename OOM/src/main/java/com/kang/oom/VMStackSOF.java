package com.kang.oom;

/**
 * Created by kang on 16-6-3.
 */

/**
 * HotSpot在虚拟机中并不区分虚拟机栈和本地方法栈,因此以-Xoss参数是无效的
 * 栈容量只由-Xss参数设定
 *
 * 这有两种异常StackOverflowError、OutOfMemoryError
 *
 * 此类测试StackOverflowError
 */

/**
 * 定义大量的本地变量,增大此方法帧中本地变量表的长度
 */
public class VMStackSOF {

    private int stackLength=1;


    public void  stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        VMStackSOF vmStackSOF=new VMStackSOF();

        try {

            vmStackSOF.stackLeak();
        }catch (StackOverflowError e){
            System.out.println("length:"+vmStackSOF.stackLength);
            throw  e;
        }
    }
}


/**
    实现表明：
        在单线程下，无论是由于栈帧太大还是虚拟机栈容量太小，
        当内存无法分配的时候,虚拟机抛出的都是StackOverflowError
**/