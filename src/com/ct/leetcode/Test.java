package com.ct.leetcode;

import java.util.Arrays;

/**
 * Created by CT on 2021/2/1.
 */
public class Test {
    public static void main(String[] args){

        TowSum towSum = new TowSum();
        int result [] = towSum.twoSum(new int[]{3,2,4},6);
        System.out.println(Arrays.toString(result));

    }
}
