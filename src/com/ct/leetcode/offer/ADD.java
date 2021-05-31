package com.ct.leetcode.offer;

/**
 * Created by CT on 2021/4/23.
 */
public class ADD {

    //负数的补码是，除了符号位以外其余个位按位取反+1；
    //不用加法的运算是异或运算
    //与运算是取第几位需要进位，左移一位进行进位
    public int add(int a, int b) {
        while (b!=0){
            int c = (a&b)<<1;
            a^=b;
            b = c;
        }
        return a;
    }
}
