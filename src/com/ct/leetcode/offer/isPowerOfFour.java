package com.ct.leetcode.offer;

/**
 * Created by CT on 2021/5/31.
 */
public class isPowerOfFour {
    //四的幂
    //怎么判断是否是4的幂
    //

    public boolean isPowerOfFour(int n) {

        //2的幂 n&(n-1) == 0 表示是2的幂
        //为什么 n &(n-1)是2的幂
        //因为对于2的幂来说，除了最高位，其它位置，都为零。
        //n-1则表示 除了最高位是零，其它位都是1
        //相交得到0则表示是二的幂
        //我们先判断是否是2的幂
        //在判断最高位是否是2进制的偶数位置
        //构造一个全在偶数位1为1的mark 0xaaaaaaaa
        return n>0 && (n&(n-1)) == 0 && (n & 0xaaaaaaaa ) == 0 ;
    }

    //如果是2的幂，且mod3==1,则肯定是4的幂

    public boolean isPowerOfFour2(int n) {

        //2的幂 n&(n-1) == 0 表示是2的幂
       //mod 3 == 0
        return (n&(n-1)) == 0 && (n % 3 == 1);
    }

}
