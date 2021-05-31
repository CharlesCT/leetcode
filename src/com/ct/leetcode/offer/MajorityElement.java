package com.ct.leetcode.offer;

/**
 * 摩尔投票
 * .
 */
public class MajorityElement {

    //寻找数组中的众数
    private int majorityElement(int []nums){
        //假设众数是x，则
        int x = 0;
        int vist = 0;
        for (int num : nums) {
            if (vist == 0)
                x = num;
            vist += x == num ? 1 : -1;
        }

        return x;
    }


}
