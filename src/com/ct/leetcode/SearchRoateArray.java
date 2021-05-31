package com.ct.leetcode;

/**
 * Created by CT on 2021/4/7.
 */
public class SearchRoateArray {


    //带有重复的数字
    //还是可以用二分法
    //不一定非要有序才能二分
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        int left = 0;
        int right = nums.length-1;
        //选一边作为参照
        while (left <= right){
            int mid = (left+right) /2;
            if (nums[mid]  == target)
                return true;
            if (nums[mid] == nums[left]){
                left++;
                continue;
            }
            if (nums[mid] > nums[left] ){
                //说明 left - mid是有序的
                if (target < nums[mid] &&  nums[left] <= target){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }else {
                //说明 mid - right是有序的
                if (target > nums[mid] && target<= nums[right]){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return false;
    }
}
