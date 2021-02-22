package com.ct.leetcode;

/**
 * leetcode88 合并两个有序数组
 * num1 和num2有序
 * num1的长度足够放入num2
 *
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // m代表num1的长度
        // n代表num2的长度
        //从后往前填，从大往小，填入num1中
        //如果一个数在num1中，他的最小的位置肯定就是当前位置了
        //比如num1 都比他小，那么他的实际位置肯定比当前位置靠后
        //如果都比他大，那么他的实际位置就是当前位置了。
        int index1 = m -1;
        int index2 = n -1;
        int current = m + n -1;
        while (current >= 0){
            //数组二空了，可以提前退出
            if (index2 ==0)
                break;
            int a = index1>=0? nums1[index1]:Integer.MIN_VALUE;
            int b = index2>=0? nums2[index2]:Integer.MIN_VALUE;
            if (a > b){
                index1 --;
            }else {
                index2 --;
            }
            nums1[current--] = Math.max(a,b);
        }
    }
}
