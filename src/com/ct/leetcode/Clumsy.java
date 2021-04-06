package com.ct.leetcode;

/**
 * leetcode 1006
 * 笨阶乘
 */
public class Clumsy {

    public int clumsy(int N) {
        //定义以恶四个操作
        //四个为一组开始做的
        if (N<=4)
            return clumite(N,true);
        int res = clumite(N,true);
        N = N-4;
        while (N>=4){
            res -= clumite(N,false);
            N = N-4;
        }
        return res - clumite(N,false);
    }

    private int clumite(int n,boolean first){
        if (n == 1 || n==0)
            return 0;
        if (n == 2)
            return 2;
        return n*(n-1)/(n-2) + (first?+(n-3):-(n-3));

    }


}
