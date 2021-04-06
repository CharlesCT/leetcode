package com.ct.leetcode;

/**
 * Created by CT on 2021/3/29.
 */
public class ReverseBits {

    //颠倒二进制位，将n的二进制进行颠倒
    //按位一移除
    public int reverseBits(int n) {

        int res = 0;
        for (int i = 1; i < 32 && n > 0; i++ ) {
            res  |=  (n&1) >> (31-i);
            n >>>= 1;
        }
        return res;
    }
}




