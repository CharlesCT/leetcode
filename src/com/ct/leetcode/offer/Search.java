package com.ct.leetcode.offer;

import com.ct.leetcode.inner.Test;

/**
 * Created by CT on 2021/5/8.
 */
public class Search {
    //在排序数组中出现的次数
    public int search(int[] nums, int target) {

        if (nums.length == 0 || nums == null)
            return 0;
        Test.INSTANCE.test();
        if (target > nums[nums.length-1])
            return 0;

        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int middle = (left + right)/2;
            if (nums[middle] == target){
                int start = middle;
                int end = start;
                while (start-1 >= 0 &&nums[start-1] == target){
                    start--;
                }
                while (end + 1 < nums.length && nums[end+1] == target){
                    end++;
                }
                return end-start +1;
            }else if (nums[middle] > target){
                right = middle-1;
            }else {
                left = middle+1;
            }
        }
        return 0;
    }
}
