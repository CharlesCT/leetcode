package com.ct.leetcode;

/**
 * Created by CT on 2021/2/1.
 */
public class LCS {

    //求两个字符串的最长公共子序列
    //问题的关键
    // 比如 现在字符串是 abc 和 abcf 来进行比较
    // 我们用dp[i][j] 来表示 A串中以A[i] B[j]的结尾的公共子序列的长度
    //我们可以得到一个公式 如果A[i] = B[j] 则最大子串是 dp[i-1][j-1] +1
    // 如果 A[i] != B[j] 则最大的子串长度 应该是 (dp[i-1][j] ,dp[i][j-1])的最大值
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length()>text2.length() )
            return longestCommonSubsequence(text2,text1);
        //声明DP数组
        int [][]dp = new int[text1.length()][text2.length()];
        //初始化都是0的
        //再次理解dp的含义 dp[i][j]指的是以[i]结尾和以B[j]结尾的两个字符串的最大子序列长度。
        for (int i = 0;i < text1.length();i++){
            for (int j = 0;j < text2.length();j++){
                if (text1.charAt(i) == text2.charAt(j)){
                    if (i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i-1][j-1] +1;
                    }
                }else {
                    dp[i][j] = Math.max(dp[i-1>0?i-1:0][j],dp[0][j-1>0?j-1:0]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }


}
