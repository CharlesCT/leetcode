package com.ct.leetcode.inner;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by CT on 2021/4/16.
 */
public class B {
    public static LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(100);

    public static void main(String[] args){

        Thread thread1 = new Thread(new Runnable() {
            int count = 0;
            @Override
            public void run() {
                while (count < 1000){

                    queue.offer("当前是第几个：" + count);
                    count++;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        String msg = queue.take();
                        System.out.println("获取到了消息:" + msg);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });




        thread1.start();
        thread.start();




    }





}
