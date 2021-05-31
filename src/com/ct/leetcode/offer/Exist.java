package com.ct.leetcode.offer;

/**
 * Created by CT on 2021/4/26.
 */
public class Exist {

    //矩阵中的路径
    //
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0)
            return false;
        if (board == null || board.length == 0)
            return false;
        char target[] = word.toCharArray();
        //dfs来做
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                if (board[i][j] == target[0]){
                    board[i][j] = '*';
                    if (dfs(board,target,1,i,j)){
                        return true;
                    }
                    board[i][j] = target[0];
                }
            }
        }
        return false;
    }

    //可以四个方向搜索
    public boolean dfs(char[][] board,char[] words,int start,int i,int j) {
        if (start == words.length)
            return true;
        boolean result = false;
        //从上开始搜索
        if (i - 1 >= 0) {
            if (board[i - 1][j] == words[start]){
                board[i - 1][j] = '*';
                result = dfs(board, words, start + 1, i - 1, j);
                board[i - 1][j] = words[start];

            }
        }

        //下
        if (i + 1 < board.length) {
            if (board[i + 1][j] == words[start]){
                board[i + 1][j] = '*';
                result = dfs(board, words, start + 1, i + 1, j);
                board[i + 1][j] = words[start];
                if (result)
                    return true;
            }
        }
        //左
        if (j - 1 >=0 ) {
            if (board[i][j-1] == words[start]){
                board[i][j-1] = '*';
                result = dfs(board, words, start + 1, i , j-1);
                board[i][j-1] = words[start];
                if (result)
                    return true;
            }
        }

        //右边
        if (j + 1 < board[0].length) {
            if (board[i][j+1] == words[start]){
                board[i][j+1] = '*';
                result = dfs(board, words, start + 1, i , j+1);
                board[i][j+1] = words[start];
                if (result)
                    return true;
            }
        }
        return false;
    }





















}
