package com.ct.leetcode;

import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 森林中的兔子
 */
public class NumRabbits {

    //
    //不能单靠简单的搜索来查找
    //
    public int numRabbits(int[] answers) {
        int res = 0;
        //用来计算同一个数量出现的次数
        HashMap<Integer,Integer> count = new HashMap<>();
        for (int answer : answers) {
            count.put(answer, count.getOrDefault(answer, 0) + 1);
        }
        //我们可以得到兔子的数量是
        // x/(y+1) * (y+1)
        for (Integer y : count.keySet()) {
            int x = count.get(y);
            res += (x+y) / (y + 1) * (y + 1);
        }


        return res;
    }
}
