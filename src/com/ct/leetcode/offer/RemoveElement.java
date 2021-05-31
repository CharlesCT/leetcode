package com.ct.leetcode.offer;

/**
 * Created by CT on 2021/4/19.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        //删除数组中为 val的数字，并且返回数组的长度。
        if (nums == null || nums.length == 0)
            return 0;
        int fast = 0;
        //如果fast的 val.
        //
        int count = 0;
        while (fast < nums.length){
            if (nums[fast] == val){
                count++;
            }else {
                nums[fast-count] = nums[fast];
            }
        }
        return nums.length-count;
    }

}
