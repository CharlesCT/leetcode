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
                    dp[i][j] = Math.max(dp[i-1>0 ? i-1: 0][j],dp[i][j-1>0?j-1:0]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

    /**
     * 输出两个字符串的最长公共子串
     *我们使用
     * dp[i][j] 来表示字符串A和字符串B 以A[i] 和B[j]结尾的最长公共子串的长度
     * 比如 A：abc B:abdef
     * dp[2][4] 意思是以c和f 同时结尾的最长子串的长度
     * 这样的子串存在吗？肯定不存在 所以dp[2][4]为0
     * 要理解含义 dp[i][j] 是以A[i]和B[j]结尾的子串长度
     * 所以必定是 A[i]和B[j]相等的时候才有意义
     * 否则根本找不出这样的串
     *
     *
     * 如果 A[i] == B[j] 这时候dp[i][j] = dp[i-1][j-1] +1;
     * 否则 dp[i][j] = 0
     * 为什么是零？ 因为以A[i] 和B[j]结尾的公共串不存在。
     *
     * 什么时候
     * @param text1
     * @param text2
     * @return
     */
    public String longestCommonString(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0)
            return null;
        //保持text1的长度大于text2
        if (text1.length() < text2.length())
            return longestCommonString(text2,text1);

        if (text1.contains(text2))
            return text2;
        //使用dp
        int dp[][] = new int[text1.length()][text2.length()];
        int endIndex = 0;
        int maxlength = 0;
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)){
                    if (i == 0 || j == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = dp[i-1][j-1] + 1;
                    if (maxlength < dp[i][j]){
                        maxlength = dp[i][j];
                        endIndex = i;
                    }
                }else {
                    dp[i][j] = 0;
                }

            }
        }
        
        return endIndex == -1? "-1": text1.substring(endIndex - maxlength+1,endIndex+1);
    }



    //最长公共子序列

    /**
     * 还是动态规划的思想
     * 使用dp数组
     * dp[i][j] 表示以 A[i] 和B[j]结尾的最长子序列
     * 如果 A[i] = B[j]则dp[i][j]= dp[i-1][j-1] +1;
     * 否则
     * dp[i][j] = max(dp[i-1][j],dp[i][j-1])
     *
     * @param text1
     * @param text2
     * @return
     */
    public String longestCommonSubsequence_new(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0)
            return "-1";
        StringBuilder result = new StringBuilder();
        int dp[][] = new int[text1.length()][text2.length()];
        int max = 0;
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)){
                    if (i == 0|| j == 0)
                        dp[i][j] = 1;
                    else{
                        dp[i][j] = dp[i-1][j-1] +1;
                    }
                }else {
                    dp[i][j] = Math.max(i>0?dp[i-1][j]:0,j>0? dp[i][j-1]: 0);
                }
            }
        }
        System.out.print(dp[text1.length()-1][text2.length()-1]);
        int str1Length = text1.length()-1;
        int str2Length = text2.length()-1;
        while (str1Length >= 0 && str2Length >= 0){
            char a = text1.charAt(str1Length);
            char b = text2.charAt(str2Length);
            if (str1Length == 0 && str2Length == 0){
                if (a == b)
                    result.append(a);
                break;
            }
            if (a == b){
                str1Length --;
                str2Length --;
                result.append(a);
            }else{
                if (dp[str1Length>0?str1Length-1:0][str2Length] > dp[str1Length][str2Length>0?str2Length-1:0]){
                    str1Length--;
                }else {
                    str2Length --;
                }
            }
        }
        return result.length() > 0?result.reverse().toString():"-1";
    }
}
