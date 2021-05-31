package com.ct.leetcode;

import java.util.Arrays;

/**
 * 左旋字符串
 */
public class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0)
            return s;
        int k = n % s.length();
        if (k == 0)
            return s;
        //左旋
        StringBuilder builder = new StringBuilder(s);
        int right = s.length()-1;
        int left = k;
        while (left < right){
            char temp = builder.charAt(left);
            builder.setCharAt(left,builder.charAt(right));
            builder.setCharAt(right,temp);
            left++;
            right--;
        }
        right = k-1;
        left = 0;
        while (left < right){
            char temp = builder.charAt(left);
            builder.setCharAt(left,builder.charAt(right));
            builder.setCharAt(right,temp);
            left++;
            right--;
        }
        //整天反转
        return builder.reverse().toString();
    }
    //需要反转吗！！！！！不需要，额外空间高一些就完事了



    public String reverseLeftWords_res(String s, int n) {
        if (s == null || s.length() == 0)
            return s;
        int k = n % s.length();
        if (k == 0)
            return s;
        //左旋
        StringBuilder builder = new StringBuilder();
        for (int i = n; i < n + s.length() ; i++) {
            builder.append(s.charAt(i % s.length()));
        }
        //整天反转
        return builder.toString();
    }


    public String reverseLeftWords_3(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }







}
