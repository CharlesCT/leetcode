package com.ct.leetcode;

/**
 * Created by CT on 2021/3/23.
 */
public class maxProduct {


    /**
     * 子数组最大的乘积
     * 使用dp[i]来表示A[i]结尾的子数组的最大承继
     *
     * * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0)
            return  0;

        int min_value = nums[0];
        int max_value = nums[0];
        //[2,3,-2,4]
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max_value;
            //当前的最大值
            max_value  = Math.max(Math.max(max_value * nums[i] , min_value * nums[i]),nums[i]);
            //当前的最小值
            min_value = Math.min(Math.min(temp * nums[i] , min_value * nums[i]),nums[i]);


            max = Math.max(max_value,max);
        }
        return max_value;
    }

}
