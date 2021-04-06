package com.ct.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 组合
 *leetcode 77
 */
public class Combine {

    //给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
    public List<List<Integer>> combine(int n, int k) {
        // 1.。n K个数的所有组合 skr
        List<List<Integer>> res = new LinkedList<>();
        if (n < k)
            return res;
        Stack<Integer> stack = new Stack<>();
        //还是老样子回溯法子
        findCombine(1,n,k,stack,res);
        return res;
    }


    public void findCombine(int start,int n,int k,Stack<Integer> stack, List<List<Integer>> res){

        //减枝
        if (stack.size() + (n - start + 1) < k) {
            return;
        }
        if (stack.size() == k){
            //加入集合
            res.add(new ArrayList<>(stack));
            return;
        }
        //这里不用循环来做
        //还是那个选择和不选择的问题
        //选择当前这个是
        stack.push(start);
        findCombine(start+1,n,k,stack,res);
        stack.pop();
        //不选择当前这个数
        findCombine(start+1,n,k,stack,res);


    }







}
