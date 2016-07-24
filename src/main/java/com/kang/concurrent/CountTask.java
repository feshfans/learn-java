package com.kang.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by kang on 16-6-14.
 */


/**
 * JDK1.7开始新增了fork/join
 * 本例用来测试Fork/Join框架
 */
public class CountTask extends RecursiveTask<Integer>{
    private static final int threshold=2;
    private int start;
    private int end;

    public CountTask(int start,int end){
        this.start=start;
        this.end=end;
    }

    @Override
    protected Integer compute() {
        int sum=0;

        boolean canCompute=(end-start)<=threshold;
        if(canCompute){
            for(int i=start;i<=end;i++){
                sum+=i;
            }
        }else{

            int middle=(start+end)/2;
            CountTask lefeTask=new CountTask(start,middle);
            CountTask rightTask=new CountTask(middle+1,end);

            lefeTask.fork();
            rightTask.fork();

            int leftSum=lefeTask.join();
            int rightSum=rightTask.join();

            sum=leftSum+rightSum;

        }
        return sum;
    }


    public static void main(String[] args) {
        ForkJoinPool forkJoinPool=new ForkJoinPool();

        CountTask task=new CountTask(1,4);

        Future<Integer> result=forkJoinPool.submit(task);


        //异常处理
        if(task.isCompletedAbnormally()){
            System.out.println(task.getException());
        }
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
