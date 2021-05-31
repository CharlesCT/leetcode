package com.ct.leetcode;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by CT on 2021/4/5.
 */
public class CoinChange {

    //凑零钱
    //需要找出需要的最小零钱树
    public int coinChange(int[] coins, int amount) {
        if (amount<1)
            return 0;
        //这里还是自己写一个排序吧
        quickLick(coins,0,coins.length -1);
        return findPath(amount,coins,0);
        //快排
        //这里用一个dp数组来保存，搜索过的数量吧
        //比如 我们又 1 2 5 三种类型
        // 需要找出的 数组为8
        //我们这里会出现各种重复搜索
    }

    //快排
    public void quickLick(int []coins,int start,int end){
        if (start >= end)
            return ;

        int left = start;
        int right = end;
        //哨兵
        int temp = coins[left];
        while (left < right){
            //从右边找一个比哨兵大的
            while (left < right){
                if (coins[right] > temp)
                    break;
                right++;
            }
            //从左边找一个比哨兵小的
            while (left < right){
                if (coins[left]< temp)
                    break;
                left --;
            }
            //交换位置
            swap(left,right,coins);
        }
        //和哨兵交换位置
        swap(start,left,coins);
        //分治
        quickLick(coins,start,left-1);
        quickLick(coins,left+1,end);
    }

    public void swap(int a,int b,int[] nums){
        if ( a != b){
            int temp = nums[b];
            nums[b] = nums[a];
            nums[a] = temp;
        }
    }




    public int findPath(int target,int[]coins,int count){
        if (target == 0) {
            //这里找到了
            return count;
        }
        if (target < 0)
            return -1;
        for (int i = 0; i < coins.length; i++) {
            int res = findPath(target - coins[i], coins, count+1);
            if (res != -1){
                return res;
            }
        }
        return -1;

    }











    //草 过不了啊！！！！！！！！！
    //回溯不行！！！！
    //我们这里减枝吧
    public int findPath(int target, int[] coins, int set[]) {

        if (target == 0) {
            //这里找到了
            return 0;
        }
        if (target < 0)
            return -1;
        if (set[target - 1] != 0)
            return set[target - 1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = findPath(target - coins[i], coins, set);
            if (res>=0 && res <min){
                min = res + 1;
            }
        }
        set[target - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return set[target - 1];
    }














    //这里如果我们用深度优先搜索，必定会超时！
    //即使优化了效率也很差
    //我们应该要使用动态规划
    //我们用动态规划来思考一些
    //考虑一些问题
    //如果用dp[n]来表示这个数字可以被零钱组合总数
    //我么可以得到

    //dp[n] =  dp[n -conin[1]] + dp[n-con[i]]

    //使用 dp[n] 来代表
    // dp[n]需要的最小硬币树木
    // dp[n] =  min(dp[n-conin[i]]  +1. （这里的i是从 0-i]递增。
    //我们可以自下而上的进行计算.

    //public
    public int coinChange_new(int[] coins, int amount) {
        if (amount<1)
            return 0;
        int dp[] = new int[amount+1];
        //如果这里不初始化为anmoun+1
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 1; i <=amount ; i++) {
            for (int coin : coins) {
                if (coin <= i){
                    System.out.println(i);
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == 0?-1:dp[amount];
    }



}
