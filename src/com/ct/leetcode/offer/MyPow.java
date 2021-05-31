package com.ct.leetcode.offer;

/**
 * Created by CT on 2021/4/27.
 */
public class MyPow {

    //数值的n次方
    //任意一个数在二进制中都表示成
    // 2(k-1） + 。。。 + 2（1）；
    public double myPow(double x, int n) {
        long b = n;

        if (n < 0){
            x = 1/x;
            b = -b;
        }
        double res = 1;
        while (b!=0){
            if ((b &1 )== 1){
                res *= x;
            }
            //高位移往低位
            b >>= 1;
            x*=x;
        }
        return res;
    }

}
