package com.ct.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode 子集
 */
public class Subsets {


    /**
     * 找到数组的所有子集
     * 不能包含重复元素
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {


        if (nums == null )
            return null;
        List<List<Integer>> res = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        findChildren(0,nums,res,stack);
        return res;
    }

    public void findChildren(int start,int[]nums,List<List<Integer>> res,Stack<Integer> stack){

        if (start == nums.length) {
            res.add(new LinkedList<>(stack));
            return;
        }
        //从当前值出发，

        //我们可以加入当前值,也可以不加入
        findChildren(start + 1, nums, res, stack);

        stack.add(nums[start]);
        //寻找下一个
        findChildren(start + 1, nums, res, stack);
        //回溯
        stack.pop();

    }



    //可以使用二进制来做，时间复杂度可以降低到O（n2）


    public List<List<Integer>> subsets_new(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0 )
            return res;
        //拆分成二进制
        int n = (int) (Math.pow(2,nums.length) -1);
        for (int i = 0; i <= n; i++) {
            List<Integer> temp = new ArrayList<>();
            int count = 0;
            int start = i;
            while (start !=  0){
                if ( (start&1) == 1){
                    temp.add(nums[count]);
                }
                start >>= 1;
                count++;
            }
            res.add(temp);
        }
        return res;
    }
















}
