package com.ct.leetcode.offer;

import java.util.*;

/**
 * Created by CT on 2021/4/11.
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0 || k == 0)
            return new int[0];
        //设置单调栈
        int [] result = new int[nums.length-k+1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length  ; i++) {
            //从头往前找最大值肯定是最先失效的。
            while (!queue.isEmpty()&&nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            if (i-k>= queue.peekFirst()){
                queue.pollFirst();
            }
            if (i >= k - 1) {

               result[i-k+1] = nums[queue.peekFirst()];
            }
        }
        return result;
    }




}
