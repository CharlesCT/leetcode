package com.ct.leetcode;

import com.ct.leetcode.offer.MinNumber;

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





    public static void main(String args[]){
        int a = 3;
        int b = 30;
        int c = 30;
        int d = 33;
        MinNumber minNumber = new MinNumber();
        minNumber.minNumber(new int[]{3,30,34,5,9});
    }



}
