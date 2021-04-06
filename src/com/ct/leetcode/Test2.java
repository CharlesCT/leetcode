package com.ct.leetcode;

/**
 * Created by CT on 2021/3/31.
 */
public class Test2 {

    private final Object lock = new Object();
    public synchronized void testSyncMethod(){
        System.out.print("method sync");
    }

    public void testSyncObject(){
        synchronized (lock){
            System.out.print("object sync");
        }
    }

    public static synchronized void testStaticMethod(){
        System.out.print("static method sync");
    }


}
