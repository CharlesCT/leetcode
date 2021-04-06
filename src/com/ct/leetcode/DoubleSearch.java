package com.ct.leetcode;

/**
 * 阿里真题
 * 寻找重复升序数组中的tager
 * 如果存在返回下标，
 * 否则为1
 */
public class DoubleSearch {

    //可以是二分解决的
    public int search (int[] nums, int target) {
        // write code here
        int left = 0;
        int right = target-1;

        while (left < right){
            int middle = (left + right)/2;
            if (nums[middle] >=target){
                //
                right = middle;
            }else {
                left = middle+1;
            }
        }
        return nums[left] == target?left:-1;

    }
}
