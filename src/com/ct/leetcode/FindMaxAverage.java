package com.ct.leetcode;

/**
 * 查找一个数组中的连续K个数的平均数
 */
public class FindMaxAverage {

    //很明显是滑动窗口，定义left 和right指针
    //right = k-1;
    //计算sum
    //计算平均数，然后左移left 和right
    // sum = sum - A[left] + A[right]
    public double findMaxAverage(int[] nums, int k) {

        int left = 0;
        int right = 0;
        int sum = 0;
        int average = Integer.MIN_VALUE;
        while (right < nums.length){
            //没到K呢
            if (right < k ){
                sum += nums[right];
            }else {
                sum = sum - nums[left] + nums[right];
                left++;
            }
            average = Math.max(average,sum/k);
            right ++;
        }
        return average;
    }
}
