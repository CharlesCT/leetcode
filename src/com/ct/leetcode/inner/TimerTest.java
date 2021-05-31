package com.ct.leetcode.inner;

import org.omg.CORBA.TIMEOUT;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by CT on 2021/4/18.
 */
public class TimerTest {



    public static void main(String []args){
        Timer timer = new Timer();
        timer.schedule(new TestTask(),1000,2000);
    }


    static class TestTask extends TimerTask{

        @Override
        public void run() {
            System.out.println("执行任务");
        }
    }

}
