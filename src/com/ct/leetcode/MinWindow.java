package com.ct.leetcode;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 牛客网真题 最小覆盖子串
 */
public class MinWindow {

    /**
     *给出两个字符串 SS 和 TT，要求在O(n)O(n)的时间复杂度内在 SS 中找出最短的包含 TT 中所有字符的子串。
     例如：
     S ="XDOYEZODEYXNZ"S="XDOYEZODEYXNZ"
     T ="XYZ"T="XYZ"
     找出的最短子串为"YXNZ""YXNZ".
     * @param S string字符串
     * @param T string字符串
     * @return string字符串
     */
    public String minWindow (String S, String T) {
        if(S == null || S.length() == 0 || T == null || T.length() == 0)
            return "";
        int []set = new int[128];
        for (int i = 0; i < T.length(); i++) {
            set[T.charAt(i)]++;
        }
        int left = 0 ;
        int right = 0;
        int start = 0;
        int max = Integer.MAX_VALUE;
        int count = T.length();
        while (right < S.length()){
            if (set[S.charAt(right)]>0){
                count--;
            }
            set[S.charAt(right)]--;//把加入窗口的字符进行计数
            if (count == 0){
                //已经找到了当前的这个字符的匹配
                while (left<right&& set[S.charAt(left)] <0){
                    //说明这个字符不在T里面,而且在窗口里面，我们肯定排除他
                    set[S.charAt(left)]++;//把这个字符排除
                    left++;
                }
                //找到了一个窗口
                if (max > right - left){
                    max = right - left;
                    start = left;
                }
                //开始左移一下
                //把这个字符排除掉
                set[S.charAt(left)]++;
                left ++;
                count++;
            }
            right++;
        }
        return max == Integer.MAX_VALUE? "": S.substring(start,start + max + 1);


    }


}
