package com.ct.leetcode;

/**
 * Created by CT on 2021/2/20.
 * 最长重复子串的长度
 */
public class LongestDupSubstring {


    //暴力的方法
    //思考一个问题
    //你一个数字，如果是数组中重复的，你最多是数组长度的一半。
    //所以我们的窗口最大值肯定是数组长度的一半 比如数组长度是4，一半就是二
    //然后从下标0开始查找，跳动
    public int longestDupSubstring(String s) {
        //很明显我们要从每一个字符开始递归
        if (s == null || s.length() == 0 )
            return 0;
        if (s.length() == 1)
            return 1;
        char [] chars = s.toCharArray();
        int start = 0;
        int maxlength = 0;
        int window = s.length()/2;
        //先指定一个窗口
        for (int i = window; i > 0 ; i--) {
            for (int j = 0; j + 2* i <= s.length(); j++) {
                if (isCommon(i,j,chars))
                    return 2 * i;
            }
        }
        return 0;
    }

    //判断两个字符串是否相等
    public boolean isCommon(int window,int start,char[] chars){
        for (int i = 0; i <window ; i++) {
            if (chars[start+i] != chars[start+window+i])
                return false;
        }
        return true;
    }




}
