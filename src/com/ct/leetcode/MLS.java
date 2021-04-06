package com.ct.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 阿里面试真题最长递增自序里
 */
public class MLS {

    public int MLS (int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int max = 1;
        HashSet<Integer> map = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            map.add(arr[i]);
        }
        for (int anArr : arr) {
            if (map.contains(anArr - 1)) {
                continue;
            }
            //从当前在这个值开始递增
            int start = anArr+1;
            int count = 1;
            while (map.contains(start)) {
                count++;
                start++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
