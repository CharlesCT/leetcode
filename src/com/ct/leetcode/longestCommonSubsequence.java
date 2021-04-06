package com.ct.leetcode;

/**
 * Created by CT on 2021/4/3.
 */
public class LongestCommonSubsequence {


    //求出text1 和text2的最长公共子序列
    public int longestCommonSubsequence(String text1, String text2) {

        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0)
            return 0;

        if (text1.length() < text2.length())
            return longestCommonSubsequence(text2,text1);
        if (text1.contains(text2))
            return text2.length();

        //动态规划来做
        //定义dp[i][j] 表示字符串，A[i] 和B[j]几位的最长公共子串
        //可以得到递归公式
        //A[i] = B[j] dp[i][j] = dp[i-1][j-1] +1
        //A[i]!=B[j] dp[i][j] = max(dp[i-1][j],dp[i][j-1])
        //得到递推公式之后开始动态规划

        int dp[][] = new int[text1.length()][text2.length()];
        int max = 0;
        //这里开始动态规划
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)){
                    if (i == 0 || j == 0){
                        dp[i][j] =  1;
                    }else {
                        dp[i][j] =  dp[i-1][j-1] + 1;
                    }
                }else {
                    dp[i][j] = Math.max(i>0 ? dp[i-1][j]:0,j>0?dp[i][j-1]:0);
                }

            }
        }
        return dp[text1.length()-1][text2.length()-1];
    }
}
