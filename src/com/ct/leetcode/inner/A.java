package com.ct.leetcode.inner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by CT on 2021/4/11.
 */
public class A  {

    public static int count = 1;
    public static final Object  lock = new Object();
    public static final CountDownLatch countDounLatch = new CountDownLatch(2);


    public static void main(String args[]){

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    while (count < 2000){
                        if (count % 2 == 1){
                            System.out.println("线程A 执行" + count);
                            count++;
                        }
                        try {
                            lock.notify();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });




        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    while (count < 2000){
                        if (count % 2 == 0){
                            System.out.println("线程B 执行" + count);
                            count++;
                        }

                        try {
                            lock.notifyAll();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });


     /*   thread1.start();
        thread2.start();*/


        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1请求内容回来了");
                countDounLatch.countDown();

            }
        });


        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("线程2请求协议回来了");
                    //等待一秒 还不回来 就去进入首页了
                   countDounLatch.await(1, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        thread3.start();
        thread4.start();
   /*     try {
            countDounLatch.await();
            //等待两个线程回来
            System.out.println("两个线程都执行完了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


    }




}
