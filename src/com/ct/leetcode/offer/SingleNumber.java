package com.ct.leetcode.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 */
public class SingleNumber {


    //方案1 hashset
    //统计每一位的个数
    //然后对3取模，
    public int singleNumber(int[] nums) {
        //位运算
        int []bit = new int[32];//统计每一位1的个数
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                bit[j] += (num&1);
                num>>=1;
            }
        }
        //统计好了每一位的数字
        int res = 0; int m = 3;
        for (int i = 0; i <bit.length ; i++) {
            res <<= 1;
            res |= bit[31-i] %  m;
        }
        return res;
    }



}
