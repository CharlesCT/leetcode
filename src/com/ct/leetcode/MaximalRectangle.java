package com.ct.leetcode;

import java.util.Stack;

/**
 * 求出leetcode中的最大矩形
 *
 *给定一个仅仅包含0和1，大小为row 和cols的二维矩阵，找出包含1的最大矩形的面积
 *
 */
public class MaximalRectangle {


    //思考我们怎么计算啊
    //我们可以从每一行来计算
    //假设整个数组只有一行
    //就类似柱状图的 算法了。
    //维持一个递增的序列，不过里面只有0，和1两个高度
    //如果有两行
    //我们可以先计算柱状图的高度
    //比如 当前行 为A[i][j] 如果A[i][j] == 0，这以i这行A[i][j]这个柱子就是0，
    //如果A[i][j] ==1 ，则这个柱子应该是 1 + A[i][j]的高度
    public int maximalRectangle(char[][] matrix) {
        //我们真的并不需要对每一个点为底的柱子的高度都做一个保存，我们只需要保存当前的就可以了。
        //还是和求最大柱状图面积一样的思路

        //为什么要+2,为了避免递增栈为空的时候进行处理。
        if (matrix.length == 0)
            return 0;

        int [] height = new int[matrix[0].length +2];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                height[j + 1] = matrix[i][j] == '0' ? 0 : height[j + 1] + 1;
            }
            //栈来做啊
            Stack<Integer> stack  = new Stack<>();
            stack.add(0);
            for (int j = 1; j < height.length; j++) {
                while (height[stack.peek()] > height[j]){
                    //出栈，并且计算最大面积
                    //这个矩形的左边边界就是自己
                    int h = height[stack.pop()];
                    int w = j - stack.peek()-1;
                    res = Math.max(w * h,res);
                }
                stack.add(height[j]);
            }
        }
        return res;
    }

}
