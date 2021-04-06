package com.ct.leetcode;

/**
 * 牛客网阿里面试真题
 * 找到两个数组长度相等的中位数
 * 给定两个有序数组arr1和arr2，已知两个数组的长度都为N，求两个数组中所有数的上中位数。
 上中位数：假设递增序列长度为n，若n为奇数，则上中位数为第n/2+1个数；否则为第n/2个数
 *
 *
 */
public class FindMedianinTwoSortedAray {

    public int findMedianinTwoSortedAray (int[] arr1, int[] arr2) {
        //两个数组长度相等必为偶数
        int k = arr1.length * 2 /2;
        int start1 = 0;
        int start2 = 0;
        int end1 = arr1.length-1;
        int end2 = arr2.length-1;
        //求K个数吗
        while (k != 1) {
            //如果k ==1 比较两个数值的
            System.out.print("当前的K是： " + k);
            if (start1 > end1 || start2 > end2)
                return start1 > end1 ? arr2[start2+k-1] : arr1[start1+k-1];
            //先在两个数组里面取 k/2个数
            int middle1 = k / 2 + start1 - 1 > end1 ? end1 : k / 2 + start1 - 1;
            int middle2 = k / 2 + start2 - 1 > end2 ? end2 : k / 2 + start2 - 1;
            if (arr1[middle1] > arr2[middle2]) {
                System.out.print("淘汰Arr2中的个数： " + (middle2 - start2 + 1));
                //淘汰arr2中前 k/2个数
                k -= middle2 - start2 + 1;
                start2 = middle2+1;
            } else {
                System.out.print("淘汰Arr2中的个数： " + (middle1 - start1 + 1));
                k -= middle1 - start1 + 1;
                start1 = middle1+1;
            }
        }
        //如果k ==1 比较两个数值的
        if (start1 > end1 || start2 > end2)
            return start1 > end1 ? arr2[start2] : arr1[start1];
        return arr1[start1] > arr2[start2] ? arr2[start2] : arr1[start1];
    }


}
