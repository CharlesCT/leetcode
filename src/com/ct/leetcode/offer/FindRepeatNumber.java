package com.ct.leetcode.offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by CT on 2021/4/17.
 */
public class FindRepeatNumber {

    //找寻数组中的重复的数字

    /**
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
     * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     来源：力扣（LeetCode）
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                return num;
            else
                set.add(num);
        }

        return -1;
    }

    /**
     * 原地置换
     * @param nums
     * @return
     */
    public int findRepeatNumber_new(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                return num;
            else
                set.add(num);
        }
        return -1;
    }












}
