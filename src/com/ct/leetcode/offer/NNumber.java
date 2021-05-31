package com.ct.leetcode.offer;

/**
 * Created by CT on 2021/4/12.
 */
public class NNumber {

    //输入一个整数n 计算 number的值
    // 比如 n = 5 number =2
    //计算 2 + 22 + 222+ 2222+ 22222
    //不麻烦！

    public int findNNnumber(int number,int n){
        int sum = 0;
        int current = 0;
        for (int i = 1; i <= n ; i++) {
            current = current * 10 + number;
            System.out.println(current);
            sum += current;
        }
        return sum;
    }
}
