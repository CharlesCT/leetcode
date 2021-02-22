package com.ct.leetcode;

/**
 * Created by CT on 2021/2/7.
 */
//leetcode 655
public class CheckPossibility {

    //非递减列
    //改变一个数让其称为非递减列
    //不存在nums[i]<=nums[i+1]
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 0|| nums.length == 1)
            return true;
        int count = 0;
        for (int i = 1; i < nums.length ; i++) {
            if (nums[i] < nums[i-1]){
                if (i == 1 || nums[i] >= nums[i-2]){
                    nums[i-1] = nums[i];
                }else {
                    nums[i] = nums[i-1];
                }
                count++;
            }
        }
        return count<=1;
    }

}
