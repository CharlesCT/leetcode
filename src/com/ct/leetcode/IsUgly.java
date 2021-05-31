package com.ct.leetcode;

import javax.swing.text.TabExpander;

/**
 * Created by CT on 2021/4/10.
 */
public class IsUgly {

    //寻找丑数
    //丑数 就是只包含质因数 2、3 和/或 5 的正整数。
    public boolean isUgly(int n) {
        int count[] = new int[]{2,3,5};
        for (int aCount : count) {
            while (n % aCount == 0)
                n = n / aCount;
        }
        return n ==1;
    }


    /**
     * 自下而上去找
     * @param n
     * @return
     */
    public boolean isUgly_new(int n) {
        int twoSum =1;
        int threeSum =1;
        int fiveSum =1;
        int sum = 1;
        while (sum <= n){
            if (sum == n)
                return true;
            sum = Math.min(Math.min(threeSum *2 ,3 *threeSum),5 * fiveSum);
            if (sum == 2 * twoSum ){
                twoSum = threeSum;
            }else if (sum == 3 * threeSum){
                threeSum = fiveSum;
            }else {
                fiveSum = twoSum;
            }
        }
        return false;
    }


    //寻找丑数

    //把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
    //
    public int GetUglyNumber_Solution(int index) {
        int[] uglyArray = new int[index];
        uglyArray[0] = 1;
        //下一个丑数肯定是在第一个的基础上乘以2或者乘以3 或者乘以5
        //取其最小值
        int currentIndex = 1;
        //开始循环查找
        //丑数= 丑数*丑数 没有其他的方式，只能是丑数*丑数得到
        //这三个下标代表的意思就是，每一次使用当前下标取进行丑数计算，都需要把下标+1
        //计算下一个丑数的流程，比如通过求第二个丑数
        //我们第一个丑数是1，第二个丑数肯定是1 * 2 1*3 1*3的最小值 计算得出为2
        //在计算第三个丑数 这时候我们肯定不能计算 1*2了因为1*2已经计算过了！
        //所以我们用过一个丑数进行计算的时候，下次计算的时候，就需要把数组下标加一 防止重复计算 比如这时候我们计算的是 2*2
        //同理，对于3 和5我们也需要一个下标来保存当前使用的丑数到第几个了。
        //
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while (currentIndex < index){
            int temp = midValue(uglyArray[p2] * 2,uglyArray[p3] * 3,uglyArray[p5] * 5);
            uglyArray[currentIndex] = temp;
            if ( temp == uglyArray[p2] * 2){
                //是通过2 计算的 下标+1
                p2++;
            }
            if ( temp == uglyArray[p3] * 3){
                //是通过2 计算的 下标+1
                p3++;
            }
            if ( temp == uglyArray[p5] * 5){
                //是通过2 计算的 下标+1
                p5++;
            }
            currentIndex++;
        }

        return uglyArray[index-1];
    }
    public int midValue(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }


    //第N个丑数
    public int nthUglyNumber(int n) {
        //对于第N个丑数，我们可以可能需要使用一个数组来做
        int dp[] = new int[n];
        //dp[i]代表第i个丑数
        dp[0] = 1;
        int preTwo = 0;
        int preThree = 0;
        int preFive = 0;
        int start = 1;
        while (start < n){
           int temp = Math.min(Math.min(dp[preTwo]* 2,dp[preThree] *3),dp[preFive] *5);
            System.out.print(temp);
            if (temp == dp[preTwo] *2){
                preTwo ++;
            }else if (temp == dp[preThree] *3){
                preThree ++;
            }else if (temp == dp[preFive] * 5){
                preFive ++;
            }
            dp[start] = temp;
            start++;
        }
        return dp[n-1];

    }







}
