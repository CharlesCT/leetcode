package com.ct.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetode 岛屿的数量
 */
public class NumIslands {

    //我们使用深度优先遍历快来做
    public int numIslands(char[][] grid) {
        //可以用
        if (grid == null || grid.length == 0)
            return 0;
        int count = 0;


        for (int i = 0; i < grid.length; i++) {
            //遍历每一行加入队列中
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1'){
                    findPath(grid,i,j);
                }
            }
        }
        return count;
    }

    public void findPath(char[][]grid,int i,int j){
        if (i <0 || i >= grid.length || j<0 || j>= grid[0].length)
            return;
        //四个方向搜索
        //向上搜索
        grid[i][j] = 0;
        if (i-1>=0 && grid[i-1][j] == '1'){
            grid[i-1][j] = '0';
            findPath(grid,i-1,j);
        }
        //向左搜索
        if (j-1>=0 && grid[i][j-1] == '1'){
            grid[i][j-1] = '0';
            findPath(grid,i,j-1);
        }
        //向右搜索
        if (j+1<grid[0].length && grid[i][j+1] == '1'){
            grid[i][j+1] = '0';
            findPath(grid,i,j+1);
        }
        //向下搜索
        if (i+1<grid.length && grid[i+1][j] == '1'){
            grid[i][i+1] = '0';
            findPath(grid,i+1,j);
        }
    }



    //使用广度优先遍历来做








    public int numIslands_new(char[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;

        int k = grid[0].length;
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    count++;
                    queue.add(i *k + j);
                    grid[i][j] = 0;
                    while (!queue.isEmpty()){
                        int point = queue.remove();
                        int x = point / k;
                        int y = point % k;
                        //向上
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            grid[x - 1][y] = '0';
                            queue.add((x - 1) * k + y);
                        }

                        //向左
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            grid[x][y - 1] = '0';
                            queue.add(x * k + y - 1);
                        }
                        //向右搜索
                        if (y + 1 < grid[0].length && grid[x][y + 1] == '1') {
                            grid[x][y + 1] = '0';
                            queue.add(x * k + y + 1);
                        }

                        //向下搜索
                        if (x + 1 < grid.length && grid[x + 1][y] == '1') {
                            grid[x+1][y] = '0';
                            queue.add((x+1) * k + y);
                        }
                    }
                }

            }

        }

        return count;

    }
















}
