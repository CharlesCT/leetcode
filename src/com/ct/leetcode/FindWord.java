package com.ct.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 找寻单词是否存在
 * leetcode 79
 */
public class FindWord {

    /**
     * 搜索单词是否存在
     * 还是用回溯法
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] targets = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == targets[0]){
                    board[i][j] = '*';
                    if (isViited(board,targets,i,j,1)){
                        return true;
                    }
                    //还原回去
                    board[i][j] = targets[0];
                }
            }
        }


        //每一行每一列的开始搜索
        return false;
    }

    public boolean isViited(char[][] borad,char[] word,int i,int j,int start){
        //从这个开始搜索
        //已经找到了
        if (start == word.length)
            return true;
        //向左搜索
        if (j -1 >= 0 && borad[i][j-1] == word[start] ){
            //从这个点搜索下一个
            borad[i][j-1] = '*';
            if (isViited(borad,word,i,j-1,start+1))
                return true;
            //还原回去
            borad[i][j-1] = word[start];
        }
        //向右搜索
        if (j +1 < borad[j].length && borad[i][j+1] == word[start] ){
            //从这个点搜索下一个
            borad[i][j-1] = '*';
            if (isViited(borad,word,i,j+1,start+1))
                return true;
            //还原回去
            borad[i][j+1] = word[start];
        }

        //向上搜索
        if (i -1 >=0 && borad[i-1][j] == word[start] ){
            //从这个点搜索下一个
            borad[i-1][j] = '*';
            if (isViited(borad,word,i-1,j,start+1))
                return true;
            //还原回去
            borad[i-1][j] = word[start];
        }
        //向下搜索
        if (i+1 < borad.length && borad[i+1][j] == word[start] ){
            //从这个点搜索下一个
            borad[i+1][j] = '*';
           if (isViited(borad,word,i+1,j,start+1))
               return true;
            //还原回去
            borad[i+1][j] = word[start];
        }
        return false;
    }











}
