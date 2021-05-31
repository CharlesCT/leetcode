package com.ct.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CT on 2021/4/20.
 */
public class SpiralOrder {

  //  给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素
    //螺旋矩阵
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resulut = new ArrayList<>();
        if (matrix == null ||matrix.length == 0)
            return resulut;
        //输出第一行
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0;
        int left = 0;
        int right = n-1;
        int bottom = m-1;
        while (true){
            //遍历上方
            for (int i = top; i <= right; i++) {
                resulut.add(matrix[top][i]);
            }
            top++;
            if (top > bottom)
                break;
            //遍历右边
            for (int i = top; i <= bottom; i++) {

                resulut.add(matrix[i][right]);
            }
            right--;
            if (right < left)
                break;
            //遍历底部
            System.out.print("left" + right +"" + left);
            for (int i = right; i <= left ; i--) {
                System.out.print("2121");
                resulut.add(matrix[bottom][i]);
            }
            bottom--;
            if (bottom< top)
                break;
            //遍历左边
            for (int i = bottom; i <= top ; i--) {
                resulut.add(matrix[i][left]);
            }
            left++;
            if (left > right)
                break;
        }
        return resulut;
    }






}
