package com.ct.leetcode;

/**
 * Created by CT on 2021/3/30.
 */
public class CanJump {

    /**
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。

     数组中的每个元素代表你在该位置可以跳跃的最大长度。

     判断你是否能够到达最后一个下标。
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {

        //判断你是否能够到大最后一个下标
        if (nums == null || nums.length == 0 || nums.length ==1)
            return true;
        //怎么能达到最后一个呢
        //看样子只能回溯法了
        //用一个集合来剪枝
        //dp 代表以及被查找过了
        boolean [] dp = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = true;
        }

        return findPath(0,nums,dp);

    }


    //对于每一个起点
    //超出时间限制了
    //思考！出现了重复求解，
    //如果从2跳到1，
    //和从3带跳到1 ，后序的查找是一样的
    //思考用DP数组来做
     //3 2 1 0
    public boolean findPath(int start,int[] nums,boolean dp[]){
        if (start >= nums.length-1)
            return true;
        for (int i = 1; i <= nums[start]; i++) {
            if (start + i > nums.length ||  dp[start+ i]){
                if (findPath(start+i,nums,dp)){
                    return true;
                }
            }
        }
        dp[start] = false;
        return false;
    }

    //
    //使用DP数组来做，
    //靠 可以使用贪心算法！
    //这也是一个很重要的算法，局部最优积累到全局最优
    public boolean canJump_new(int[] nums) {

        //判断你是否能够到大最后一个下标
        if (nums == null || nums.length == 0 || nums.length ==1)
            return true;

        //我们不断的跳，如果有比当前跳的远的
        //就替换它
        int max = 0;//能跳的最大距离
        for (int i = 0; i < nums.length; i++) {
            //如果当前位置已经大于当前跳的最远的地方，返回false/
            if (i > max)
                return false;
            //一个跳保留跳的最远的位置
            max = Math.max(i+nums[i],max);
        }

        return true;
    }









}
