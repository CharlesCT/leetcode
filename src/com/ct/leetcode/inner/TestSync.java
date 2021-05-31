package com.ct.leetcode.inner;

/**
 * Created by CT on 2021/4/23.
 */
public class TestSync {



    public static void main(String args[]){

        Syn syn = new Syn();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                syn.printObj();

            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
               Syn.print();
            }
        });
        thread1.start();
        thread2.start();

    }
    static class Syn{
        public static synchronized void print(){
            System.out.println("im static synchronized");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        public synchronized void printObj(){
            System.out.println("im obj");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }









}
