package com.ct.leetcode;

/**
 * Created by CT on 2021/2/3.
 */
public class SingleNums {

    /**
     * 寻找数组中的重复的两个数字
     * 除了这个两个数字之外，其余的数字都出现了两次
     * 要求时间复杂度为 o(n) 空间复杂度为0（1）
     * 我们首先想到的是异或
     * 最后的值二进制位 xi..a3..a0;
     * x[i] = 1说明两个数在这个位置上是不等的 比如 a 和 b
     *ai != bi
     * 但是对于其他的数来说他们是肯定相等的 比如 3和3 4和4 他们的每一位都相等 说明3和3 必定在同一组
     *  4和4 必定在同一组 对与 a 和b肯定不会再一组
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        //一个数和0 异或还是自己
        //两个相同的数异或 是零
        for (int i: nums){
            ret ^= i;
        }
        int div = 1;
        while ((div & ret) == 0){
            div <<= 1;
        }
        int a = 0; int b = 0;
        //分为 a组和b组
        for (int i : nums){
            if ((i & div) != 0){
               a ^= i;
            } else {
                b ^= i;
            }
        }
        return new int[]{a,b};
    }



    //寻找数组中只出现一次的两个数字
    //回忆一下
    //什么时候我们去出现两次数字
    //记住两个特性
    // 一个整数与零异或还是自己
    //一个整数与自己异或为0
    //这两个数肯定都不相同
    //我们只要把他们分到两个组里面 然后异或就可以得到结果了
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int ret = 0;
        for (int aNum1 : num1) {
            ret ^= aNum1;
        }
        int div = 1;
        while ((div &ret) == 0){
            div <<= 1;//左移一位，找到相交为1的地方
        }
        int a = 0;//分成AB两组
        int b = 0;//分成AB两组
        for (int i = 0; i < array.length ; i++) {
            if ((array[i] & div ) == 0){
                a ^=  array[i];
            }else {
                b ^=  array[i];
            }
        }
        num1[0] = a;
        num2[0] = b;
    }





























}
