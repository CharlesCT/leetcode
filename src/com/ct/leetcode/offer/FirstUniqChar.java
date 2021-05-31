package com.ct.leetcode.offer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by CT on 2021/4/29.
 */
public class FirstUniqChar {

    //在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0)
            return ' ';
        char chars[] = s.toCharArray();
        //这里开始遍历，查找当前这个数组的第一个词
        char [] count = new char[26];
        for (int i = 0; i < chars.length; i++) {
            count[chars[i] - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (count[chars[i] -'a'] == 1)
                return chars[i];

        }
        return ' ';
    }
}
