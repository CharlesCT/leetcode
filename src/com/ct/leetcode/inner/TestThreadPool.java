package com.ct.leetcode.inner;

import java.util.concurrent.*;

/**
 * Created by CT on 2021/4/27.
 */
public class TestThreadPool {



    //这里是
    public static void main(String args[]){

        //这种方式和 execute没啥区别
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,2,1000, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(5000);
                return 1;
            }
        });
        poolExecutor.submit(futureTask);
        try {
            futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(5000);
                return 12;
            }
        };
        Future<Integer> future = poolExecutor.submit(callable);
        try {
            int a = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }







}
