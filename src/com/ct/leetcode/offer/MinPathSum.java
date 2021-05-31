package com.ct.leetcode.offer;

/**
 * Created by CT on 2021/4/22.
 */
public class MinPathSum {

    //找到数组之和最小的路径
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length ==0 )
            return -1;

        int m = grid.length;
        int n = grid[0].length;
        int [][]dp = new int[m][n];
        //定义dp[i][j] 是走到i,j这个坐标点的最小值
        //则 dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+1;
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                if (i ==0 && j==0){
                    dp[i][j] = grid[0][0];
                }else {
                    dp[i][j] = Math.min(i == 0 ?Integer.MAX_VALUE: dp[i - 1][j], j == 0 ? Integer.MAX_VALUE : dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
