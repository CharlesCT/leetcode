package com.ct.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

/**
 * 寻找一个连续数组
 * 对这个子数组进行排序，那么整个数组都会变成升序数组
 *
 */
public class FindUnsortedSubarray {


    /**
     * 第一种方法，直接排序，然后遍历找到位置变动的就是答案。
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        //使用栈来做
        Stack<Integer> stack  = new Stack<>();
        int left = nums.length-1;
        int right = 0;
        //从头开始找一个最小的值
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty()&& nums[stack.peek()] > nums[i]){
                left = Math.min(stack.pop(),left);
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length-1; i >=0 ; i--) {
            //找到一个降序序列
            while (!stack.isEmpty()&& nums[stack.peek()]<nums[i]){
                left = Math.max(right,stack.pop());
            }
            stack.push(i);
        }
        return right - left > 0 ? right - left + 1 : 0;
    }




    //我们可以不使用栈来做
    //无序数组中最小值会决定左边界
    //最大值决定右边界
    public int findUnsortedSubarray_new(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        //使用栈来做
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]<nums[i-1]){
                flag = true;
            }
            if (flag) min = Math.min(min,nums[i]);
        }
        flag = false;
        for (int i = nums.length -2; i >=0 ; i--) {
            if (nums[i+1] < nums[i]){
                flag = true;
            }
            if (flag) max = Math.max(max,nums[i]);
        }
        //从头开始找位置
        int left;
        int right;
        for (left = 0; left < nums.length; left ++) {
            if (nums[left] > min)
                break;
        }
        for (right = nums.length-1; right >=0 ; right--) {
            if (nums[right] < max)
                break;

        }

        return right - left > 0? right-left+1:0;
    }






}
