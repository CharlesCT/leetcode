package com.ct.leetcode.offer;

import com.ct.leetcode.ListNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by CT on 2021/5/6.
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null)
            return null;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB){
            tempA = tempA == null?headB:tempA.next;
            tempB = tempB == null?headA:tempB.next;
        }
        return tempA;
    }




    //递增
    public int[] twoSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target- nums[i])){
                return new int[]{target-nums[i],nums[i]};
            }
            set.add(nums[i]);
        }
        return null;
    }


    public int [] twosum_new(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            if (nums[left] + nums[right] == target){
                return new int[]{nums[left],nums[right]};
            }else if (nums[left] + nums[right] > target){
                right--;
            }else {
                left++;
            }
        }
        return null;
    }









}
