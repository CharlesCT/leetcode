package com.ct.leetcode.offer;

/**
 * Created by CT on 2021/4/16.
 */
public class MinNumber {


    //输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
    //[3,30,34,5,9]
    //定义一种运算
    //进行排序就完事了
    //330 303
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0){
            return "";
        }
        number(0,nums.length-1,nums);
        StringBuilder result = new StringBuilder();
        for (int num : nums) {
            result.append(num);
        }
        return result.toString();
    }



    public void number(int start,int end,int[] nums){
        if (start >= end)
            return;
        int left = start;
        int right = end;
        int temp = nums[left];
        while (left < right){

            while (left < right){
                //从后往前找一个小比哨兵小的
                if (temp == nums[right] || bigger(temp,nums[right]))
                    break;
                right--;
            }
            while (left < right){
                if (nums[left] != temp && !bigger(temp,nums[left]))
                    break;
                left++;
            }
            swap(left,right,nums);
        }
        swap(start,left,nums);
        number(start,left-1,nums);
        number(left+1,end,nums);

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

    public void swap(int a,int b,int nums[]){
        if (a != b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }











}
