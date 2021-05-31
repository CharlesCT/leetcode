package com.ct.leetcode.offer;

/**
 * Created by CT on 2021/4/18.
 */

//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。

public class RemoveDuplicates {

    //我们需要返回删除后的数组长度
    //还是按照之前的思路
    //我们把快慢针来做啊
    //快慢针不香吗
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast<nums.length){
            if (nums[slow] == nums[fast]){
                fast ++;
            }else {
                nums[++slow] = nums[fast];
            }

        }
        return slow+1;
    }





}
