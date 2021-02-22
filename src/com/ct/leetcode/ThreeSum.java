package com.ct.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by CT on 2021/2/18.
 */
public class ThreeSum {

    /**
     * 在一个数组中找到三数之和为0的组合
     * @param num
     * @return
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        if (num == null || num.length == 0)
            return null;
        //先排序
        Arrays.sort(num);
        //定义三个点，left mid 以及right
        //我们从头到尾开始遍历，
        //如果num[left]> 0 ,则不用遍历了
        //如果num[left] == num[left-1] 则去重跳过
        //
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < num.length-1; i++) {
            if (num[i] > 0)
                break;
            if (i>0 && num[i] == num[i-1]) {
                //去重啊
                continue;
            }
            int right = num.length-1;
            int mid = i+1;
            //在这里查找两数之和
            while (mid < right){
                if (num[mid] + num[right] + num[i] == 0){
                    res.add(new ArrayList<Integer>(Arrays.asList(num[i],num[mid],num[right])));
                    mid++; right--; // 首先无论如何先要进行加减操作
                    //去重操作
                    while (mid < right && num[mid] == num[mid - 1]) mid++;
                    while (mid < right && num[right] == num[right + 1]) right--;
                }else if (num[mid] + num[right] > 0 -num[i]){
                    //大了
                    right--;
                }else {
                    //小了
                    mid++;
                }

            }
        }
        return res;
    }


    /**
     * 进阶版在一个数组中找到三数之和为K的组合
     */
    public ArrayList<ArrayList<Integer>> treeSumForK(int num[],int k){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (num == null || num.length < 3)
            return res;
        //对Nums进行排序
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            //排除一些情况
            if (num[i] > k)
                break;
            if (i >0 && num[i] == num[i-1])
                continue;
            //三个下标
            int target = k - num[i];
            int right = num.length-1;
            int mid = i+1;
            while (mid < right){
                //去重
                if (num[mid] + num[right] == target){
                    //一个解
                    res.add(new ArrayList<>(Arrays.asList(num[i], num[mid], num[right])));
                    right--;
                    mid++;
                    //去重肯定是在结果中去重，如果这个结果已经加入过集合了，应该去重
                    while ( mid <right  && num[right] == num[right+1])
                        right--;
                    while (mid < right && num[mid] == num[mid-1])
                        mid++;
                }else if (num[mid] + num[right] > target){
                    right --;
                }else {
                    mid ++;
                }
            }
        }
        return res;
    }

























}
