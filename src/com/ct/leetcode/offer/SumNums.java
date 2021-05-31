package com.ct.leetcode.offer;

/**
 * Created by CT on 2021/4/28.
 */
public class SumNums {
    public int sumNums(int n) {
        // 求出前n项和，

        //递归来做
        if (n == 1)
            return 1;
        return n+sumNums(n-1);
    }
    class Solution {
        public int sumNums(int n) {
            int ans = 0, A = n, B = n + 1;
            boolean flag;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            return ans >> 1;
        }
    }

}
