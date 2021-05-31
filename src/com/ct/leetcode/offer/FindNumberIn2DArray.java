package com.ct.leetcode.offer;

/**
 * Created by CT on 2021/4/16.
 */
public class FindNumberIn2DArray {


    /**
     * 二维数组的查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;

        //从右上角开始找
        int n = matrix.length-1;
        int row = 0;
        int column = matrix[0].length-1;

        while (row<=n  && column >=0){
            if (matrix[row][column] == target)
                return true;
            else if (matrix[row][column] > target){
                //这里开始找
                column--;
            }else {
                row++;
            }
        }
        return false;
    }



}
