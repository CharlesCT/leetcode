package com.ct.leetcode.inner;

/**
 * Created by CT on 2021/5/18.
 */
public class TestMay {


    public static int max(int nums[]){

        int start = nums[0];
        int a =  nums[1];//学习消耗的精力
        int b = nums[2];//休息回复的精力
        int n = nums[3];
        //初始精力为start 如果选择学习则知识会增加，精力会减少。
        //动态规划根本找不出来。。。。
        //直接暴力回溯
        return max(start,0,n,a,b,0);
    }

    /**
     *
     * @param start 开始精力
     * @param index 当前是第几天
     * @param n 总共第几天
     * @param a  学习消耗精力
     * @param b 休息获取到精力
     * @param  res 获取到的知识
     * @return
     */
    public static int max(int start,int index,int n,int a,int b,int res ){
        if (index == n)
            return res;

        //当前这个小时选择学习,精力减少 a，知识增加start
        int learn = max(start-a,index+1,n,a,b,res + start);
        //当前这个小时选择休息,精力增加 b，知识不变
        int sleep =  max(start+b,index+1,n,a,b,res);

        return Math.max(learn,sleep);
    }




    public static void main(String args[]){


        int nums[] = new int[]{10,5,5,3};
        System.out.print(max(nums));

    }





}
