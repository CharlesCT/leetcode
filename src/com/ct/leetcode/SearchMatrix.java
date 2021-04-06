package com.ct.leetcode;

/**
 * leetcode 搜索二维矩阵
 */
public class SearchMatrix {

    /***
     * leetcode 74
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        //从最右上角开始搜索
        if (matrix == null || matrix.length == 0)
            return false;
        //右上角开始搜索
        int top = 0;
        int right = matrix[0].length-1;
        while (top < matrix.length && right >= 0) {
            if (matrix[top][right] == target)
                return true;
            //说明有可能在这一行啊
            if (target < matrix[top][right]) {
                right--;
                while (right >= 0) {
                    if (matrix[top][right] == target)
                        return true;
                    else if (matrix[top][right] < target) {
                        top++;
                        break;
                    }
                }
            } else {
                //抛弃这一行
                top++;
            }
        }
        return false;
    }
}
