package com.ct.leetcode;

/**
 * Created by CT on 2021/2/5.
 */

/**
 * 把两个长度相同的字符串，转为相等的字符串的开销
 */
public class EqualSubstring {

    /**
     * 很明显用滑动窗口来做
     * @param s
     * @param t
     * @param maxCost
     * @return
     */
    public int equalSubstring(String s, String t, int maxCost) {
        if (t.length() == 0)
            return 0;
        int left = 0;
        int right = 0;
        int max = 0;
        while (right<t.length()){
            int val = Math.abs(s.charAt(right) - t.charAt(right));
            if (maxCost >= val){
                right++;
                maxCost -= val;
                max = Math.max(right-left,max);
            }else {
                if (left!=right){
                    maxCost += Math.abs(s.charAt(left) - t.charAt(left));
                    left++;
                }else {
                    left++;
                    right++;
                }

            }
        }
        return max;
    }

}
