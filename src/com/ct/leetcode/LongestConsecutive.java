package com.ct.leetcode;

import java.util.HashSet;

/**
 *最长连续子序列
 * leetcode 128
 */
public class LongestConsecutive {


    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i: nums){
            set.add(i);
        }
        int maxlength = 0;
        for (int numbers :set) {
            //判断是不是序列中的最小值，我们从最小值开始统计
            if (!set.contains(numbers-1)){
                int currentLength = 1;//当前这个序列的长度
                int current = numbers;
                while (set.contains(current+1)){
                    current++;
                    currentLength ++;
                }
                maxlength = Math.max(currentLength,maxlength);
            }

        }
        return maxlength;
    }
}
