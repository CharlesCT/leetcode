package com.ct.leetcode.offer;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by CT on 2021/5/22.
 */
public class CombinationSum4 {


    int count = 0;


    //组合，如果 1,3不一致，4，1也是可以的 需要去重
    public int combinationSum4(int[] nums, int target) {
        //使用hash Set去重
        //排序
        int [] dp = new int[target+1];
        //假设 nums[i] = target
        // dp[tatget] += dp[0],则dp[0] = 1
        dp[0] = 1;
        //对于一个target在 nums中有一个序列之和为 target，如果是从小到的序列
        //假设序列为 0=<i<target,假设最后一个数为i，则
        //taget-i ,也应该有一个序列与之对应
        //dp[taget]+=dp[taget-nums[i]]
        for (int i = 0; i < dp.length; i++) {
            for (int num : nums) {
                if (num < i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }




    public static void main(String args[]){
        double price =  20.0;
        BigDecimal big = new BigDecimal(8.42);
        int i = big.intValue();

        System.out.print(i);

    }





}
