package com.ct.leetcode;

import java.util.*;

/**
 *
 * 输入: [1,2,2]
 输出:
 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 *
 */
public class SubsetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //带有重复的子集
        List<List<Integer>> res = new ArrayList<>();

        //我们用hashSet进行去重
        if (nums == null || nums.length == 0){
            return res;
        }
        findChild(nums,0,new Stack<Integer>(),res,new StringBuilder(),new HashSet<String>());
        return res;
    }


    /**
     *寻找当前的所有子集
     * @param nums
     * @param start
     * @param stack
     * @param res
     */
    public void findChild(int[] nums, int start, Stack<Integer> stack, List<List<Integer>> res, StringBuilder path, HashSet<String> set){
        if (start == nums.length){
            String key = path.toString();
            if (!set.contains(key)){
                res.add(new ArrayList<>(stack));
                set.add(key);
            }
            return;
        }
        //对于一个数可以选择也可以不选择
        //我们不选取这个
        findChild(nums,start+1,stack,res,path,set);
        //得去重啊！
        //我们选取这个
        path.append(nums[start]);
        stack.push(nums[start]);
        //我们也可以不选去
        findChild(nums,start+1,stack,res,path,set);
        path.deleteCharAt(path.length()-1);
        stack.pop();
    }






    public List<List<Integer>> subsetsWithDup_new(int[] nums) {
        //带有重复的子集
        List<List<Integer>> res = new ArrayList<>();

        //我们用hashSet进行去重
        if (nums == null || nums.length == 0){
            return res;
        }
        //看来要排序
        Arrays.sort(nums);
        findChild(nums,0,new Stack<Integer>(),res);
        return res;
    }


    public void findChild(int[] nums, int start, Stack<Integer> stack, List<List<Integer>> res){
        res.add(new ArrayList<>(stack));
        //怎么去重呢
        for (int i = start; i < nums.length; i++) {
            if (i> start && nums[i-1] == nums[i]){
                //肯定被前面的数字选择过了，跳过
                continue;
            }
            //选取这个数
            stack.add(nums[i]);
            findChild(nums,i+1,stack,res);
            stack.pop();
        }

    }

    //不使用回溯来做，使用广度优先，对于每一个数都以他为开头去寻找



    public List<List<Integer>> subsetsWithDup_new_2(int[] nums) {
        //带有重复的子集
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        //以i为开头，去寻找以i为开头的子集
        //一个数的子集 2个数的子集 三个数的子集
        //四个数的子集一直到N个数的子集
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        int start = 1;
        for (int i = 0; i < nums.length; i++) {
           List<List<Integer>> res_temp = new ArrayList<>();
            for (int j = 0; j < res.size(); j++) {
                //去重
                //如果出现重复数字，就跳过所有旧解
                if (i > 0 && nums[i] == nums[i - 1] && j < start) {
                    continue;
                }
                List<Integer> list = res.get(j);
                List<Integer> tem = new ArrayList<>(list);
                tem.add(nums[i]);
                res_temp.add(tem);
            }
            //更新start
            start = res.size();
            res.addAll(res_temp);
        }
        return res;
    }











}
