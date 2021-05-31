package com.ct.leetcode.inner;

import com.ct.leetcode.Merge;

/**
 * Created by CT on 2021/4/28.
 */
public class JudgeSquareSum {

    public boolean judgeSquareSum(int c) {
        if (c == 0)
            return true;
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right){
            long sum = left * left + right * right;
            if (sum == c)
                return true;
            if (sum > c){
                right -- ;
            }else {
                left ++;
            }
        }
        return false;
    }
}
