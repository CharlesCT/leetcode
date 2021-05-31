package com.ct.leetcode.offer;

/**
 * Created by CT on 2021/4/20.
 */
public class printNumbers {

    public int[] printNumbers(int n) {
        int sum = 9;
        for (int i = 1; i < n; i++) {
            sum = sum*10 + 9;
        }


        int[] result = new int[sum];
        for (int i = 1; i <=sum ; i++) {
            result[i-1]  = i;
        }

        return result;
    }

    int count =0;
    //全排列来做
    public int[] printNumbersNew(int n){
        char loop[] = new char[]{'0','1','2','3','4','5','6','7','8','9'};
        int [] result = new int[(int) (Math.pow(10,n)-1)];
        char[] child = new char[n];
        dfs(loop,result,0,n,child);
        return result;
    }

    public void dfs(char[]loop,int []result,int start,int n,char[]child){
        if (start == n){
            int temp = Integer.parseInt(String.valueOf(child));
            if (temp > 0){
                result[count] = temp;
            }
        }
        //递归
        for (int i = 0; i < loop.length; i++) {
            child[start] = loop[i];
            dfs(loop,result,start,n,child);
        }

    }














}
