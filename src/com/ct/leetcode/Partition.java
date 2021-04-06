package com.ct.leetcode;

/**
 * Created by CT on 2021/3/29.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 分割回文串
 */
public class Partition {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0)
            return res;
        //预处理一下吧，dp[i][j] 代表 i-j的是否是回文
        char[] chars = s.toCharArray();
        boolean dp[][] = new boolean[s.length()][s.length()];
        //我看可以知道如果要 dp[i][j] = a[i]==a[j] && dp[i+1][j-1]
        for (int i = 0; i < dp.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == i)
                    dp[i][j] = true;
                else {
                    if (i + 1 > j - 1)
                        dp[i][j] = chars[i] == chars[j];
                    else{
                        dp[i][j] = chars[i] == chars[j] && dp[i + 1][j - 1];
                        System.out.println("i j" + (j+1) + " " + (i-1) + dp[j+1][i-1]);
                        System.out.println("i j" + j + " " + i + dp[j][i]);
                    }

                }

            }
        }
        //假设已经搜索到字符串i了，且s[0-i-1]的字符串已经被分割成若干回文串，
        findPath(0,s,new ArrayList<>(),res,dp);
        return res;
    }

    public void findPath(int i, String s, List<String> path,List<List<String>> res,boolean[][]dp){
        //假设现在已经搜索到i了，后序所有的[0-i-1]都已经被分割了
        if (i == s.length()){
            res.add(new ArrayList<String>(path));
            return;
        }
        for (int j = i; j < s.length();j++) {
            if (dp[i][j]){
                System.out.println("当前的集合" + i + " " + j);
                path.add(s.substring(i,j+1));//是回文加入集合
                //搜索下一个数
                findPath(j+1,s,path,res,dp);
                path.remove(path.size()-1);
            }
        }
    }


}
