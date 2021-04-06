package com.ct.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CT on 2021/3/26.
 */
public class SolveNQueens {


    // 输入：4
    //输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();
        if (n == 1){
            List<String> single = new ArrayList<>();
            single.add("Q");
            res.add(single);
        }
        if (n < 4)
            return res;
        //先定义一个期盼
        StringBuilder[]  metrix = new StringBuilder[n];
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(".");
            }
            metrix[i] = row;
        }
        //棋盘已经有了
        //我们回溯之前，先去定义一些非法的问题
        findQueue(0,n,res,metrix);
        return res;
    }

    public void findQueue(int row,int n,List<List<String>> res, StringBuilder[] metrix ){
        System.out.print(row);
        //找到了
        if (row == n){
            List<String> child = new ArrayList<>();
            //加入结果
            for (int i = 0; i < n; i++) {
                child.add(metrix[i].toString());
            }
            res.add(child);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isInvalid(row, j, n, metrix)) {
                //设置当前这个值为皇后
                metrix[row].setCharAt(j, 'Q');
                //查找下一行
                findQueue(row + 1, n, res, metrix);
                //回溯这个
                metrix[row].setCharAt(j, '.');
            }
        }
    }

    public boolean isInvalid(int row, int colum, int n, StringBuilder[] metrix ) {
        //判断同一行有没有数据
        for (int i = 0; i < n; i++) {
            if (metrix[row].charAt(i) == 'Q')
                return false;
        }
        for (int i = 0; i < n; i++) {
            if (metrix[i].charAt(colum) == 'Q')
                return false;
        }
        //判断右上角是否有皇后
        for (int i = row,j =colum ; i >=0 && j<n; i--,j++) {
            if (metrix[i].charAt(j) == 'Q')
                return false;
        }
        //判断左上角是否有皇后
        for (int i = row,j = colum ; i >=0 && j >=0 ; i--,j--) {
            if (metrix[i].charAt(j) == 'Q')
                return false;
        }
        //不要判断下里面，下面还没开始找呢！！！
        return true;

    }




























}
