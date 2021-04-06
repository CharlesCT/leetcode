package com.ct.leetcode;

/**
 * Created by CT on 2021/4/5.
 */

//合并两个有序数组
public class MergeTwo {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //假设num1的空间等于 == m + n;
        //从屁股开始填写
        int end1 = m-1;
        int end2 = n-1;
        int count = 1;
        while (end1 >=0 && end2 >= 0){
            if (nums1[end1] > nums2[end2]) {
                nums1[m + n - count] = nums1[end1--];
            } else {
                nums1[m + n - count] = nums2[end2--];
            }
            count++;
        }
        while (end2 >= 0){
            nums1[m + n - count] = nums2[end2--];
            count++;
        }
      //  [4,5,6,0,0,0]
      //  3
        //        [1,2,3]
     //   3
        //[4,5,1,4,5,6]


    }
}
