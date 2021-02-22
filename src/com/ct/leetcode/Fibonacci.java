package com.ct.leetcode;

/**
 * Created by CT on 2021/2/20.
 */
public class Fibonacci {
    public int Fibonacci(int n) {
        //斐波那契
        //还是老思想 我们使用 dp数组来表示状态
        //f(n) = f(n-1) + f(n-2);
        int[] dp = new int[n+1];//dp[i]表示
        //dp[0] = 0
        //dp[1] = 1
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    //我们可以当前状态值依赖前面两个状态啊 没有必要保存所有状态
    public int Fibonacci_new(int n) {
        //斐波那契
        //还是老思想 我们使用 dp数组来表示状态
        //f(n) = f(n-1) + f(n-2);
        //dp[0] = 0
        //dp[1] = 1
        int dp_0 = 0;
        int dp_1 = 1;
        for (int i = 2;i<=n;i++){
            int temp = dp_0 + dp_1;
            dp_0 = dp_1;
            dp_1 = temp;
        }
        return dp_1;
    }


}
