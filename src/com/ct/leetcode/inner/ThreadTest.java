package com.ct.leetcode.inner;

import com.ct.leetcode.offer.GetLeastNumbers;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.concurrent.*;

/**
 * Created by CT on 2021/4/21.
 */
public class ThreadTest {

    private static ThreadPoolExecutor threadPoolExecutor = new
            ThreadPoolExecutor(2,8,10, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>(5));


    public static void main(String args[]){

        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        //[0,0,1,2,4,2,2,3,1,4]


        ArrayBlockingQueue<Runnable> runnables = new ArrayBlockingQueue<Runnable>(10);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,10,5, TimeUnit.SECONDS,runnables);
        BigDecimal bigDecimal = new BigDecimal("64.80");
        BigDecimal bigDecimal1 = new BigDecimal("0.05");
        BigDecimal count =  bigDecimal.divide(bigDecimal1);


        System.out.print(count.subtract(count).toString().equals("0"));
  /*      for (int i = 0; i < 12; i++) {
            final int finalI = i;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("current thread is: " + Thread.currentThread().getName() + " " + finalI);
                }
            });
        }*/


        //getLeastNumbers.getLeastNumbers(new int[]{0,0,1,2,4,2,2,3,1,4},8);
    }



}
