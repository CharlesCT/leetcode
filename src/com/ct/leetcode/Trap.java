package com.ct.leetcode;

/**
 * leetocde 接雨水的问题
 * 在一个容器里面接入，雨水，有高有低
 *
 *
 */
public class Trap {
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int left = 0;
        int right = height.length-1;
        int result =  0;
        while (left < right){
            int min;
            if (height[left] > height[right] && right>left){
                min = height[right];
                //开始递减
                while (height[right] <= min){
                    result += min - height[right];
                    right --;
                }
            }else {
                min = height[left];
                while (height[left] <= min && left<right){
                    result += min - height[left] ;
                    left ++;
                }
            }
        }
        return result;
    }



}
