package com.ct.leetcode;
import java.util.HashSet;
/**
 * Created by CT on 2021/2/1.
 */
public class FairCandySwap {


    //A[]数组和B数组交换一个值，使得B数组和A数组的总和相等
    //数学问题， sumA - x + y = sumB - y + x
    //可以得到x -y = (sumA - sumB)/2;
    //找到这两个值，还是两数之和的变种
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        HashSet<Integer> set = new HashSet<>(0);
        for (int i:A){
            sumA +=i;
            set.add(i);
        }
        int sumB = 0;
        for (int i:B){
            sumB +=i;
        }
        //还是用两数之和的方法
        // a- b = tagget
        int target = (sumA + sumB)/2;
        int[] res = new int[2];
        for (int j : B) {
            if (set.contains(target + j)) {
                res[0] = target + j;
                res[0] = j;
                break;
            }
        }
        return res;
    }

}
