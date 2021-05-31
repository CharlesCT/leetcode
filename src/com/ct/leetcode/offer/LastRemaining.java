package com.ct.leetcode.offer;
/**
 * 打印圆圈中的
 *
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 */
public class LastRemaining {

    public int lastRemaining(int n, int m) {
        //递归来做
        //设置当前的显示问题
        //f(n,m)再n个数中一直选取第m个数,直至最后一个数的下标
        // f(n,m)，求出n个数中，选取第m个数，最后保留的那个数的下标。
        // f(n-1,m) 再n-1个数中选取m个数，最后保留的的那个数的下标
        //f(n-1,m)=x f(n-1,m)有什么关系
        //设置 f(n-1)
        //第一次 m取m个数
        // （m-1）%n
        //从下一个开始继续选取 x个数
        //f(n-1,m) = x
        // (m-1)%n +1 +x == (m+x)%n
        int f = 0;
        for (int i = 2; i <= n; i++) {
            f = (f + m) %i;
        }
        return f;
    }
}
