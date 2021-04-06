package com.ct.leetcode;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * leetcode 560
 * 和为K的子数组
 */
public class SubarraySum {


    int count = 0;
    //暴力法子会超时？
    //为什么？因为我们对数组的每一个都进行了深度搜索
    //但是会出现很多无用的枝，比如：
    //1 2 3 4 5 数组 我需要寻找和为k的数
    //我们对第一个数进行搜索的时候，已经计算过了 1-5 之间的所有的数的和了
    //到第二个数为起点开始搜索的时候，又去搜索了一遍后序的数目之和。
    //太多无用的操作了。我们可以把这些数据进行保存。
    public int subarraySum(int[] nums, int k) {

        if (nums == null || nums.length == 0)
            return 0;
        for (int i = 0; i < nums.length; i++) {
            findK(i,k,nums);
        }
        return count;
    }
    public void findK(int start,int target,int[] nums){
        if (start == nums.length)
            return;
        if (nums[start] == target){
            count++;
        }
        findK(start+1,target-nums[start],nums);
    }


    /**
     * 还是超时！
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum_new(int nums[],int k) {

        //有递归的经验，我们只需要去保存搜索过的值就行了。
        //使用数组dp[][]，dp[i][j] 代表数组下标i-j的值+
        //我们可以在这个二维表里面填上半部分就行了
        // 下标2的值1-2 和2-1是一样的！
        //自然我们有 dp[i][j] = dp[i-1] [j-1] + A[i] + A[j]
        if (nums == null || nums.length == 0)
            return 0;
        int dp[][] = new int[nums.length][nums.length];
        int numbers = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == i){
                    dp[j][j] = nums[i];
                }else {
                    dp[j][i] = dp[j + 1][i - 1] + nums[i] + nums[j];
                }
                if (dp[j][i] == k)
                    numbers++;
            }
        }
        //开始比较得到K就i完事了
        return numbers;
    }


    /**
     * 能通过的方法。前缀和！
     * 使用p[i] 代表[0-i]的数组的和
     * p[i] = p[i-1] + A[i]
     * 连续数组为 k
     * pre[i]=pre[i−1]+nums[i]
     * 假设 存在连续子数组的和为p[j-i]的数组和和为k
     * p[j-i] = P[i] - p[j-1]
     *p[i] - k = p[j-1]
     * 如果这个等式出现了 必然有 j-i的序列
     * 我们只要不挺的计算 p[i]的值然后减去k
     * 保存在hash表中
     *
     *
     */
    //开始去找
    public int subarraySum_new2(int nums[],int k){
        //定义hashmap
        if (nums == null || nums.length == 0)
            return 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        //为什么要加入0的为1呢
        //因为有可能 p[i] 就等于k
        // p[i] -k = 0。
        int count = 0;
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            p+= nums[i];
            if (map.containsKey(p-k)){
                count += map.get(p-k);
            }
            //设置
            map.put(p,map.getOrDefault(p,0)+1);
        }

        return count;

    }















}
