package com.ct.leetcode.offer;

import java.util.List;

/**
 * Created by CT on 2021/4/17.
 */
public class TranslateNum {


    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成
     * “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
     * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     * 输入: 12258
     输出: 5
     解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     * @param num
     * @return
     */
    int count = 0;
    public int translateNum(int num) {
        char[] charArr = String.valueOf(num).toCharArray();
        //先转为cha
        //1 - a
        //每一位减去- '0' + ‘a’
        //每一位都有两种可能
        dfs(0,charArr);
        return count;
    }
    public void dfs(int start, char[] chars){
        if (start == chars.length){
            count ++;
            return;
        }
        if (start > chars.length)
            return;
        //选择一位
        dfs(start+1,chars);
        //判断是否小于26啊
        if (start + 1 <chars.length){
            if (chars[start] - '0' > 0){
                if ((chars[start] -'0') * 10 + chars[start+1] -'0' < 26){
                    //选择两位
                    dfs(start+2,chars);
                }
            }
        }


    }



}
