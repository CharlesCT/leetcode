package com.ct.leetcode.offer;

/**
 * Created by CT on 2021/4/27.
 */
public class MaxProfit {


    //状态方程式
    //设置为dp[i][k[0] 表示为 第i天，做了k此交易，当前持有股票的收益
    //dp[i][k][1] 表示为第i天，做了k次交易，当前没有持有股票

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0)
            return 0;
        //
        int dp[][] = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];//第一天可以选择买入
        //dp[i][1] 表示第i天做了一次交易，有可能是前一天就有股票 dp[i-1][1],
        // 也有可能是前一天就没有股票 ，今天买入了 dp[i-1][k][0] - price[i]
        //dp[i][0] 有可能是前一天就没有股票 dp[i-1[0]  ,今天卖出去了d[i-1][0][0] + price[i]
        /**
         * base case：
         dp[-1][k][0] = dp[i][0][0] = 0 今天不允许交易
         dp[-1][k][1] = dp[i][0][1] = -infinity
         状态转移方程：
         dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
         dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
         */
        //
        //

        for (int i = 1; i <prices.length ; i++) {
            //记买入为一次交易 dp[i][0][0] = 0；需要交易才有收益，否则没有收益

            dp[i][1] = Math.max(dp[i-1][1],0 - prices[i]);
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
        }
        return dp[prices.length-1][0];
    }

    //可以通过最大值最小值来做
    //最小值买入，最大值卖出就完事了




    public int maxProfit_new(int[] prices) {
        int min = prices[0];
        int maxProft = Integer.MIN_VALUE;
        for (int i = 1; i <prices.length ; i++) {
            if (prices[i] < min){
                min = prices[i];
            }
            maxProft = Math.max(prices[i] - min,maxProft);
        }
        return maxProft;
    }












}
