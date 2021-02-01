package com.ct.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CT on 2021/2/1.
 */
public class TowSum {
    //两数之和
    //关键方式 hashSet
    //a + b = target;
    //则a = target - b;
    //遍历一遍 加入map
    //在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> count = new HashMap<Integer, Integer>();
        int []result = new int[2];
        for (int i = 0;i<nums.length;i++){
            int temp = target- nums[i];
            if (count.containsKey(temp)){
                result[0] = i;
                result[1] = count.get(temp);
                break;
            }
            //否则就加入hash表
            count.put(nums[i], i);
        }
        return result;
    }
    //暴力法,对于每一个选中的元素都去匹配
    public int[] twoSum_2(int[] nums, int target) {
        int []result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1;j < nums.length;j++){
                if (nums[j] == target -nums[i]){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }




}
