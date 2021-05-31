package com.ct.leetcode.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class MovingCount {


    //
    //
    //地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
    // 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
    // 也不能进入行坐标和列坐标的数位之和大于k的格子。
    // 例如，当k为18时，机器人能够进入方格 [35, 37] ，
    // 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
    public int movingCount(int m, int n, int k) {
        //设置棋盘
        if (m == 0 || n ==0)
            return 0;
        if (k == 0)
            return 0;
        //棋盘
        boolean [][] mt = new boolean[m][n];
        mt[0][0] = true;
        return dfs(0,0,k,mt,1);

    }

    public int dfs(int i,int j,int k,boolean [][] mt,int count){
        if (getK(i,j) > k || i > mt.length || j > mt[0].length)
            return count;
        System.out.print("当前的位置：" + " i:" + " j: " + j +" count: " + count );
        //向上走
        int max = count;
        if (i - 1 >= 0 && !mt[i - 1][j]) {
            mt[i - 1][j] = true;
            max = Math.max(max, dfs(i - 1, j, k, mt, count + 1));
            mt[i - 1][j] = false;
        }

        if (i+1<mt.length && !mt[i+1][j]){
            mt[i+1][j] = true;
            max = Math.max(max, dfs(i+1,j,k,mt,count+1));
            mt[i+1][j] = false;
        }
        if (j-1>=0 && !mt[i][j-1]){
            mt[i][j-1] = true;
            max = Math.max(max, dfs(i,j-1,k,mt,count+1));
            mt[i][j-1] = false;
        }
        if (j+1>mt[0].length && !mt[i][j+1]){
            mt[i][j+1] = true;
            max = Math.max(max, dfs(i,j+1,k,mt,count+1));
            mt[i][j+1] = false;
        }
        return max;
    }


    public int getK(int x,int y){
        int sum = 0;
        while (x>0){
            sum+= x%10;
            x =x/10;
        }
        while (y>0){
            sum+= y %10;
            y = y/10;
        }
        System.out.println("当前的sum" + sum);
        return sum;
    }

    //广度优先做做
    //定义两个运动方向
    //向下运动和向右运动
    //
    public int movingCount_new(int m,int n,int k){
        if (m == 0 || n == 0)
            return 0;
        if (k == 0)
            return 1;
        int tx[] = new int[]{0,1};
        int ty[] = new int[]{1,0};
        boolean [][] mt = new boolean[m][n];
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        mt[0][0] =true;
        queue.offer(new int[]{0,0});
        while (!queue.isEmpty()){
            int [] temp = queue.poll();
            for (int i = 0; i < 2 ; i++) {
                int dex = tx[i] + temp[0];
                int dey = ty[i] + temp[1];
                if (dex <0 || dex > m || dey <0 || dey >n || getK(dex,dey) > k || mt[dex][dey] )
                    continue;
                mt[dex][dey] = true;
                queue.offer(new int[]{dex,dey});
                count++;
            }
        }
        return count;
    }



















}
