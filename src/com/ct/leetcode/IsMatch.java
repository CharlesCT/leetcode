package com.ct.leetcode;

/**
 * Created by CT on 2021/4/2.
 */
public class IsMatch {

    /**
     * 正则匹配
     * @param s
     * @param p
     *
     *
     * 假设 dp[i][j]
     * 代表s的前i个字符和 p中的前j个字符已经匹配
     * 则我们应该知道
     * 如果 p[j] = * 代表它可以匹配 0次或着多次 s[i]
     * 如果匹配0次 则忽略就完事了p[j] p[j-1]这两个字符就完事了
     * 比如 ab  和 abb* 忽略b* 代表 ab 和ab 匹配了
     * dp[i][j] = dp[i][j-2]
     * 如果匹配一次
     * s[i] = p[j-1] 匹配一次 //只做一次
     * dp[i][j] = dp[i-1][j]
     * 如果是匹配N次我们就忽略这个s[i]
     *  我们可以得到状态方程
     *  dp[i][j] =  if s[i] == p[j]  dp[i-1][j-1]      else false                  p[i] !=[*]
     *  d[i][j] =  dp[i][j-2]   ||   if s[i] = p[j-1]  dp[i-1][j]    p[i] ==[*]
     *
     *
     * @return
     */
    public boolean isMatch(String s, String p) {
        if ( s == null || p == null)
            return false;
        int m = s.length();
        int n = p.length();
        boolean [][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n ; j++) {
                if (p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-2];//不看*号
                    //看*号
                    if (match(s,p,i,j-1)){
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }else {
                    //不是型号就看当前这个数
                    if (match(s,p,i,j))
                        dp[i][j] = dp[i-1][j-1];
                }
            }

        }
        return dp[m][n];
    }

    public boolean match(String s,String p,int i,int j){
        if (i == 0)
            return false;
        if (p.charAt(j-1) == '.')
            return true;
        return s.charAt(i - 1) == p.charAt(j - 1);
    }



}
