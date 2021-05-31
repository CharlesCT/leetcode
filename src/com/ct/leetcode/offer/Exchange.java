package com.ct.leetcode.offer;

/**
 * 调整奇数在偶数在后
 */
public class Exchange {

    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0)
            return nums;
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            if (nums[left] %2 == 0){
                //交换找一个
                while (left < right){
                    if (nums[right] %2 !=0){
                        int temp = nums[right];
                        nums[right] = nums[left];
                        nums[left] = temp;
                        break;
                    }
                    right--;
                }
            }
            left++;
        }
        return nums;
    }

}
