package com.ct.leetcode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 字符串的全排列
 */
public class Permutation {

    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() == 0)
            return res.toArray(new String[res.size()]);
        char[] chidren = s.toCharArray(); //用于排列的字符串
        findAllOrder(chidren,0,res);
        return res.toArray(new String[res.size()]);
    }


    public void findAllOrder(char[] children,int start,List<String> res){

        //这里为什么到length-1.因为当递归到
        if (start == children.length-1){
            res.add(String.valueOf(children));
            return;
        }
        //因为肯定有重复的数字，需要去重
        HashSet<Character> set = new HashSet<>();
        //比如AABC 我们在对第二个A进行排序的时候，
        for (int i = start; i < children.length; i++) {
            if (set.contains(children[i])){
                continue;
            }
            set.add(children[start]);

            //加入集合
            //交换位置
            swap(start,i,children);
            //递归下一个数
            findAllOrder(children,start+1,res);
            //交换回来
            swap(i,start,children);
        }
    }

    public void swap(int a,int b,char[]chars){
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }


    /**
     * 一个没有重复数字的排列
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length == 0)
            return res;
        findAllOrder(0,nums,res);
        return res;
    }
    public void findAllOrder(int start,int []nums,List<List<Integer>> res){
        if (start == nums.length -1){
            List<Integer> children = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                children.add(nums[i]);
            }
            res.add(children);
        }
        for (int i = start; i <nums.length ; i++) {
            //交换
            swap(start,i,nums);
            findAllOrder(start+1,nums,res);
            //交换回来
            swap(i,start,nums);
        }

    }

    public void swap(int a,int b,int[]nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
