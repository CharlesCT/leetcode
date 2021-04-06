package com.ct.leetcode;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 组合的总数
 * 给定一个无重复元素的数组
 * candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 *我们先用深度优先
 * 然后在用广度优先
 * 都给他实现一遍
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        //先给数组排序
        Arrays.sort(candidates);//从到大排序
        findNums(candidates,target,res, 0,new Stack<>());
        return res;
    }

    public void findNums(int [] candidates,int target,List<List<Integer>> res,int start,Stack<Integer>children ){
        //这里是深度遍历
        for (int i = start; i < candidates.length; i++) {
            if (target == candidates[i]){
                children.add(target);
                res.add(new ArrayList<>(children));
                children.pop();
                break;
            }else if (target > candidates[i]){
                //递归查找,为什么从i开始查找，因为数字可以重用
                //考虑 2 3 4这种情况，如果i当前在2，则2被重用了，
                //如果从零开始，如果i当前为 3的位置，则它可能会 加入 3 2 2这种序列
                //这种序列我们已经加入过集合了！
                children.push(candidates[i]);


                findNums(candidates,target - candidates[i],res,i,children);
                //出栈
                children.pop();
            }else {
                break;
            }
        }
    }
















}
