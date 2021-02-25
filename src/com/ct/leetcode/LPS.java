package com.ct.leetcode;

/**
 * Created by CT on 2021/2/23.
 */
public class LPS {


    /**
     * 最长回文子序列
     * 还是思考那个问题
     * 什么是回文子序列
     * dp[i][j]
     * dp[i][j] = dp[i][j]
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;
        int dp[][] = new int[s.length()][s.length()];
        char chars[] = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            //每一个字母都是一个回文
            dp[i][i] = 1;
            for (int j = i-1; j >=0 ; j--) {
                if (chars[i] == chars[j]){
                    if (i - j < 2)
                        dp[j][i] = 2;
                    else
                        dp[j][i] = dp[j + 1][i - 1] + 2;
                }else {
                    dp[j][i] = Math.max(dp[j+1][i],dp[j][i-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }



    /**
     * 最长回文子串
     * @param s
     * 思考问题什么是回文
     * 头尾一直匹配相等，知道不能匹配位置
     * 否则不是回文
     * 还是使用dp数组来做
     * dpp[i][j] 代表从i 到j的回文长度
     * 如果 A[i] == A[j] 这时候我们还需要看
     * dp[i+1][j-1]
     * 否则
     * dp[i][j] 就不是回文
     *
     *
     *
     *
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return null;
        if (s.length() == 1)
            return s;
        boolean dp[][] = new boolean[s.length()][s.length()];
        char [] chars =  s.toCharArray();
        StringBuilder builder = new StringBuilder();
        builder.reverse()
        int maxLength = 1;
        int endIndex = 0;
        for (int i = 0; i < s.length() ; i++) {
            dp[i][i] = true;
            for (int j = i-1; j >= 0 ; j --) {
                if (i -j <2 || chars[j] == chars[i]){
                    if ( i-j < 2 ||dp[j+1][i-1]){
                        dp[j][i] = true;
                        if (i-j+ 1 > maxLength){
                            maxLength = i-j+1;
                            endIndex = i;
                        }
                    }else {
                        dp[j][i] = false;
                    }
                }else {
                    dp[j][i] = false;
                }

            }
        }
        return s.substring(endIndex - maxLength + 1,endIndex +1);

    }






}
