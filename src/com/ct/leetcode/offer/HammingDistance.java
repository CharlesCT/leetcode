package com.ct.leetcode.offer;

/**
 * Created by CT on 2021/5/27.
 */
public class HammingDistance {

    //汉明距离
    //两个数不同位置的数目
    public int hammingDistance(int x, int y) {

        //异或
        int res = x ^y;
        int count = 0;
        while (res > 0){
            if ((res &1) == 1 )
                count++;
            res>>=1;
        }
        return count;
    }





    //计数法
    //假设32位每一位都去做一次 与运算
    //得到的结果就是为1的个数是c
    //为0个数就是数组长度-c，N-c
    //则它们之间的 组合就是 n(n-c)
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1)
            return 0;
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < 30; i++) {
            int c = 0;
            for (int j = 0; j < nums.length ; j++) {
                c += (nums[j]>>i)&1;
            }
            count += c * (n - c);
        }

        return count;
    }








}
