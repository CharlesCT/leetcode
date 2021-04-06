package com.ct.leetcode;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * leetcode 647
 */
public class CountSubstrings {


    /**
     * 输入："abc"
     输出：3
     解释：三个回文子串: "a", "b", "c"

     aaa
     a a a aa  aa aaa
     * @param s
     * @return
     */

    /**
     * 暴力法
     * @param s
     * @return
     */
    public int countSubstrings(String s) {

        if (s == null || s.length() == 0)
            return 0;

        int count = 0;
        count += s.length();
        char chars[] = s.toCharArray();
        //暴力法，从长度为2开始
        for (int i = 2; i < s.length(); i++) {
            for (int j = 0; j <= s.length()- i; j++) {
                if (checkReverse(j,i,chars))
                    count++;
            }

        }
        return count;
    }

    public boolean checkReverse(int start,int num,char[] array){
        int left = start;
        int right = start + num-1;
        while (left < right){
            if (array[left] == array[right]){
                left ++;
                right--;
            }else
                return false;
        }
        return true;
    }


    /**
     * 暴力法肯定不行
     * 效率太低了
     * 我们使用中心拓展发来寻找回文
     * 中心拓展法 就是确定一个位置，然后往他的左右两翼进行拓展直到不能生成回文为止
     * 
     * @param s
     * @return
     */
    public int countSubstrings_new(String s){
        if (s == null || s.length() == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < s.length() ; i++) {

            //需要考虑回文是奇数和偶数的情况
            for (int j = 0; j <=1 ; j++) {
                //从这个位置开始进行递增
                int left = i;
                int right = i+j;
                while (left >=0 && right<s.length()&& s.charAt(left--) == s.charAt(right++)) count++;
            }
        }
        return count;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    







}
