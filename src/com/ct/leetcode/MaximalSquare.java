package com.ct.leetcode;

/**
 * 最大正方形
 * leetcode 221
 * 在一个只有0,1的矩阵中找到只包含0,1的最大正方形，并返回其面积。
 */
public class MaximalSquare {


    //对于右下角落的i，j 来说如果，它的A[i][j] == 1
    //它能画出的最大矩形取决于与他相邻的其他三个位置的正方向大小。

    //所以我们用dp[i][j]来表示 以A[i][j]为右下角坐标大大小。
    // dp[i][j] = dp[i-1][j] ,d[i
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int [][]dp = new int[m][n];
        int maxSize = 0;
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else {
                    //最左边
                    int left =0;
                    if (j-1>=0)
                        left = dp[i][j-1];
                    int top = 0;
                    if (i-1>=0)
                        top = dp[i-1][j];
                    int left_top = 0;
                    if (i-1>=0 && j-1>=0)
                        left_top = dp[i-1][j-1];
                    dp[i][j] = Math.min(Math.min(top,left),left_top)+1;
                    maxSize = Math.max(dp[i][j],maxSize);
                }


            }
        }
        return maxSize * maxSize;
    }
}
