package com.ct.leetcode;

/**
 * Created by CT on 2021/2/4.
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 * 寻找两个排序数组的中位数
 */
public class FindMedianSortedArrays {

    /**
     * 解法一我们用归并排序的思想来做
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //我们真的需要一个数组来合并吗
        //并不需要
        //当 m +n 为偶数的时候 我们的中位数粉笔是 （m+n-1)/2 + (m+n)/2
        //当m+n为奇数的时候 我们的中位数是 (m+n-1)/2;完事了
        int index1 = 0;
        int index2 = 0;
        int count = 0;
        int current = 0;
        double res = 0;
        boolean isEven = (nums1.length + nums2.length) %2 == 0;
        while (index1 < nums1.length || index2 <nums2.length ){
            int a = index1<nums1.length?nums1[index1]:Integer.MAX_VALUE;
            int b = index2<nums2.length?nums2[index2]:Integer.MAX_VALUE;
            if (isEven){
                if (count == ((nums1.length + nums2.length)/2)){
                    res = (current + Math.min(a,b))/2;
                    break;
                }
            }else {
                if (count == (nums1.length + nums2.length -1)/2){
                    res = current;
                    break;
                }
            }
            if ( a < b){
                index1++;
                current = a;
            }else {
                index2 ++;
                current = b;
            }
            count++;
        }
        return res;
    }

    //二分法
    //思考一下都是有序的
    //假设 我们要找的中位数在两个数组合并之后的第K个
    // 数组长度 分别为m ，n
    //首先我们将 K/2 一个数组一半,每一个数组都去找K/2个数
    //由于数组有序的A,B. A[k/2] < B[k/2] 我们要抛弃掉 数组A中的k/2个数
    //因为数组有序 A中的K/2个数 都小于B[K/2]，同时在B中也有K/2-1个数比B[K/2]小，所以它们都只能在K的前面，不可能达到K。
    //例如： 1 2 3 4 5 ，4  5  6  7 8 k=4 我们去掉A[k/2]（包括自己）3个数变成 4 5 ，4 5 6 7。
    // 这时候只需要在这两个数组中第1大的数就是结果了
    //当K == 1的时候，我们只需要比较 两个数组的首部谁最小就是谁
    //当数组A.length < k/2的时候我们应该取 A.length/2;
    //找到就返回！
    public double findMedianSortedArrays_new(int[] nums1, int[] nums2) {
        int left = (nums1.length + nums2.length+1)/2;//考虑奇偶数的情况 当一个数是奇数 + 2/2还是自己
        int right = (nums1.length + nums2.length+2)/2;//考虑奇偶数的情况
        return (findMedinSortedByK(0,nums1.length,0,nums2.length - 1,left,nums1,nums2)
                + findMedinSortedByK(0,nums1.length,0,nums2.length-1,right,nums1,nums2))/2;
    }

    public int findMedinSortedByK(int start1,int end1,int start2,int end2,int k,int A[],int B[]){

        //A数组没了，只在B数组里面找到K就完事了
        if (start1 > end1){
            return B[k+start2-1];
        }
        //没了
        if (start2 > end2){
            return A[k+start1-1];
        }
        if (k == 1)
            return Math.min(A[start1],B[start2]);
        //这里需要思考一下 你现在start1的地方，开始数k/2个数，包含自己所以肯定是 k/2 + start1 -1;
        int mid1 = k/2 +start1 -1 > end1? (start1 + end1)/2:k/2 + start1-1;
        int mid2 = k/2 +start1 -1 > end2? (start2 + end2)/2:k/2 + start2-1;
        if (A[mid1] > B[mid2]){
            k = k - mid2 + start2 -1;
            start2 = mid2+1;
        }else {
            k = k - mid1 + start1-1;
            start1 = mid1+1;
        }
       return findMedinSortedByK(start1,end1,start2,end2,k,A,B);
    }


    /**
     * 在两个排序数组中找到中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMiddleFormSortedArrays(int nums1[],int nums2[]){

        if (nums1.length == 0 && nums2.length == 0 )
            return -1;
        // 如果是奇数
         if ((nums1.length + nums2.length ) %2 != 0){
             return findKFromSortedArrays(nums1,0,nums2,0, (nums1.length + nums2.length)/2 +1);
         }else {
             return (findKFromSortedArrays(nums1,0,nums2,0, (nums1.length + nums2.length)/2 +1 ) + findKFromSortedArrays(nums1,0,nums2,0, (nums1.length + nums2.length)/2))/2;
         }
    }

    /**
     * 在实现中位数的之前，我们先查找第K个数
     * 因为数组A 和数组B有序 我们肯定可以使用二分法
     * 分别在 A 和B中查找 前k/2
     * 如果 A[k/2-1]  > B[k/2-1] 第K个数肯定不在B的前 k/2中
     * 比如K = 3
     * A[7,8,9]
     * B[1,2,3]
     *分别在 A中找k/2个数 就是A[0] B[0]
     * 由于 A[0] > B[0]
     * 抛弃 B中的 k/2 B就变成了[2,3]
     * 由于抛弃了一个数 K 就变成了 k= 2了
     * 寻找k/2个数 也就是 1
     * A[0] > B[1] 抛弃B[1] A[7,8,9] B[3]
     * k = k -1；
     * 这时候 k == 1
     * 直接比较A 中和B中第一个数字谁大 就完事了
     *A[0] > B[2] 则返回A[0]
     * 算法思路之后哦
     * 我们要考虑， 如果 k/2 > b.length 这时候应该使用 b.length/2;
     */
    public int findKFromSortedArrays(int num1[],int start1,int nums2[],int start2,int k){
        int end1 = num1.length;
        int end2 = nums2.length;
        //说明数组1 已经空了，直接在数组2去找
        if (start1 >= end1){
            return nums2[start2+k-1];
        }
        if (start2 >= end2){
            return num1[start1+k-1];
        }
        if (k == 1){
            return Math.min(num1[start1],nums2[start2]);
        }
        //处理越界
        int middle1 = start1+k/2 > end1 ? end1-1:start1+k/2-1;
        int middle2 = start2+k/2 > end2 ? end2-1:start2+k/2-1;
        if (num1[middle1] > nums2[middle2]){
            //抛弃 num2中的前middle2+1个数
            k = k - middle2 + start2+1;
            start2 = middle2 +1;
        }else {
            //抛弃num1中的middle1+1个数
            k = k - middle1 + start1 +1;
            start1 = middle1 +1;
        }
        return findKFromSortedArrays(num1,start1,nums2,start2,k);
    }














}
