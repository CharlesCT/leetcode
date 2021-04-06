package com.ct.leetcode;

/**
 *
 * 直方图的水量
 *
 */
public class TrapNew {
    public int trap(int[] height) {

        //定义最小的那块围栏，左右两个方向开始找围栏
        if (height == null || height.length <= 2)
            return 0;
        int left = 0;
        int right = height.length-1;
        int res = 0;
        int min = Math.min(height[left],height[right]);
        while (left < right){
           if (height[left] <= min){
               res = min -height[left];
               left++;
           }else if (height[right] <= min){
               res = min -height[right];
               right--;
           }else {
               //重新指定边界就完事了
               min = Math.min(height[left],height[right]);
           }
        }
        return res;

    }
}
