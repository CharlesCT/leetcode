package com.ct.leetcode.offer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by CT on 2021/4/20.
 */
public class FindContinuousSequence {

    //list集合
 /*   public int[][] findContinuousSequence(int target) {

    }*/

    public int[][] findContinuousSequence(int target) {
        //需要找到连续的和为tager的子数组
        if (target == 0)
            return new int[0][0];

        List<int[]> res = new ArrayList<>();

        int left = 1;
        int right = 2;

        while (left < right){
            int sum = (left +right) * (right- left+1) /2;
            if (sum == target ){
                //加入集合
                int []child = new int[right-left+1];
                for (int i = left; i <=right ; i++) {
                    child[i] = i;
                }
                res.add(child);
                right++;
            }else if (sum > right){
                //sum 》 right
                left++;
            }else {
                right++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
