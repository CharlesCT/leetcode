package com.ct.leetcode.offer;

/**
 * Created by CT on 2021/4/8.
 */
public class IsMatch {


    //动态规划来做
    // .代表可以替代任何数
    // *代表前面的那个字符可以出现0次和无数次
    //我们用dp[i][j] 来表示 s中的前i个字符和 p中的前j个字符是否匹配
    //如果 p[j] != *
    // 我们比较 s[i] == s[j]
    //如果p[j] == *
    //要记住x* 这种是一体的，你不能单独的去考虑* 单纯的*没有意义
    //1、x*出现零次 意味着 我们去考虑 s[i]和[j-2]
    //1、x* 出现1次 aa 和a* -》aa a
    //我们去比较 s[i] p[j-1]是否相等
    // 如果相等
    // dp[i][j] = dp[i-1][j]

    //我们可以写出动态方程式了
    // dpp[i][j]   if( s[i] == s[j])  p[j] != *
    //else
    //
    // if(s[i] p[j-1]) (dp[i][j] = dp[i-1][j] )|| dp[i][j-2]


    public boolean isMatch(String s, String p) {
        if (s == null || s.length() == 0 || p == null || p.length() == 0)
            return false;

        boolean [][] dp = new boolean[s.length()+1][p.length()+1];
        //我们认为空串匹配空船
        dp[0][0] = true;

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {

                if (p.charAt(j-1) != '*'){
                    dp[i][j] = isMatch(s,i,p,j) && dp[i-1][j-1];
                }else {
                    //else
                    //
                    // if(s[i] p[j-1]) (dp[i][j] = dp[i-1][j] )|| dp[i][j-2]
                    if (j - 2 >= 0)
                        dp[i][j] = dp[i][j - 2];

                    if (isMatch(s, i, p, j - 1))
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                }

            }

        }
        return dp[s.length()][p.length()];


    }

    public boolean isMatch(String s,int i,String p,int j){
        if (i <= 0)
            return false;
        if (j - 1 <= 0)
            return false;
        if (p.charAt(j-1) == '.')
            return true;
        if (s.charAt(i-1) == p.charAt(j-1))
            return true;
        return false;
    }

}
