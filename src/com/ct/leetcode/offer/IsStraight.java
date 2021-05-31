package com.ct.leetcode.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by CT on 2021/5/6.
 */
public class IsStraight {

    //大小王是0,其余的是1-13
    //如果最大值和最小值之和<5

    public boolean isStraight(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int min = 14;
        int max =  0;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] == 0)
                continue;
            if (set.contains(nums[i]))
                return false;
            set.add(nums[i]);
            min = Math.min(nums[i],min);
            max = Math.max(nums[i],max);
        }

        return max - min < 5;
    }
}
