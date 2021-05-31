package com.ct.leetcode.offer;

/**
 * Created by CT on 2021/5/6.
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {

        int m = nums.length ;
        int sum = 0;
        for (int i = 0; i <nums.length ; i++) {
            sum += nums[i];
        }
        return (m * (m+1))/2 - sum;
    }
}
