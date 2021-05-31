package com.ct.leetcode.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 输入：s = "abc"
 输出：["abc","acb","bac","bca","cab","cba"]
 //阿里面试题 当时忘记去重了
 */
public class permutation {

    public String[] permutation(String s) {
        if (s == null || s.length() == 0)
            return null;
        char[] chars = s.toCharArray();
        List<String> res = new ArrayList<>();
        findAllOrder(res,0,chars);
        String [] result = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private void findAllOrder(List<String> res,int start,char[] chars){
        if (start == chars.length){
            res.add(new String(chars));
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = start; i < chars.length; i++) {
            if (set.contains(chars[i]))
                continue;
            set.add(chars[i]);
            //交换
            swap(start,i,chars);
            //回溯
            findAllOrder(res,start+1,chars);
            swap(start,i,chars);
        }
    }


    public void swap(int a,int b,char [] chars){
        if (a != b){
            char temp = chars[a];
            chars[a] = chars[b];
            chars[b] = temp;
        }
    }












}
