package com.ct.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 最大数输出字符串
 */
public class LargestNumber {

    //不断怎么排序，这个最大数的位数是确定的
    //就是nums的所有位数加起来
    //我们就去比较就可以
    //比如 310  320  300 9
    //我们肯定先排序最高位也就是9
    //9.320 310 300
    //这样保证输出的字符在累
    //如果
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";
        //排序，遵循个位数在前的特征，后续数在后的特征，进行排序
        //进行快排
        quickStack(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
        //从头到位拼接
        StringBuilder builder = new StringBuilder();
        for (int num : nums) {
            builder.append(num);
        }
        return builder.toString();

    }

    public void quickStack(int[]nums,int start,int end){
        if (start >= end)
            return;
        int left = start;
        int right = end;
        int temp = nums[start];//哨兵
        while (left < right){
            //从右边找一个左边大的！
            while (right > left){
                if (bigger(nums[right],temp))
                    break;
                right--;
            }
            while (left > right){
                if (!bigger(nums[left],temp))
                    break;
                left++;
            }
            //交换
            swap(left,right,nums);
        }
        swap(left,start,nums);
        quickStack(nums,start,left-1);
        quickStack(nums,left+1,end);

    }

    public void swap(int a,int b,int []nums){
        if (a != b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
    public boolean bigger(int x,int y){
        long sx = 10, sy = 10;
        while (sx <= x) {
            sx *= 10;
        }
        while (sy <= y) {
            sy *= 10;
        }
        return  sy * x + y  >  sx * y + x ;

    }





}
