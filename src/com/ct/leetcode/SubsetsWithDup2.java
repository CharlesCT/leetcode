package com.ct.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *子集
 *给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class SubsetsWithDup2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        //
        Arrays.sort(nums);
        find(0,nums,new Stack<>(),res);
        return res;
    }
    //先查
    public void find(int start, int [] nums, Stack<Integer> stack, List<List<Integer>> res){
        res.add(new ArrayList<>(stack));
        for (int i = start; i < nums.length ; i++) {
            if (i > start && nums[i-1] == nums[i]){
                continue;
            }
            //得去重啊 ，什么时候去重？
            //start如果在已经被选过了
            stack.add(nums[i]);//加入集合
            find(i+1,nums,stack,res);
            //回溯
            stack.pop();
        }


    }






}
