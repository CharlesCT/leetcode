package com.ct.leetcode;

/**
 * Created by CT on 2021/2/3.
 */
public class RotatedArray {
    //旋转数组的几个题目
    //一个有序的数组经历多次旋转，比如 1 2 3 4 5 -》3  4 5 1 2

    //求出数组中的最小数
    //思路最小数肯定是第一个数
    //当一个有序数组被截断了，肯定是最大值和最小值连在一起了
    //并不是一头一尾了，我们需要找到这个最小值
    //由于数组中有重复的数据
    //还是可以通过二分法来寻找
    // left < right  mid = （left + right）/2; 一定是向下兼容的 left<=mid <right
    //如果 a[mid] > a[right]//说明 mid肯定在左排序数组里面 比如上面的3,4,5，这时候 left = mid +1;
    //如果 a[mid] < a[right] 说明mid肯定在右排序数组里面，这个mid有可能就是最小值 这时候 right = mid;
    //如果a[mid] == a[right] 这时候不能分辨出 mid是在哪一个数组 比如 1，1，1，3，1 这时候我们把 right = right -1.
    //因为right 即使是最小值，我们也有right-1来替代他
    // leetcode 154  33 81
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length -1;
        while (left < right){
           int mid = (left + right) /2;
            if (numbers[mid] > numbers[right]){
                left = mid+1;
            }else if (numbers[mid] < numbers[right]){
                right = mid;
            }else {
                right = right - 1;
            }
        }
        return numbers[left];
    }



    //找到旋转的重复升序数组中的最小值
    //还是一样的思路 二分查找
    //定义一个区间 [left ,right]
    // mid = (left + right)/2; left < right 则 mid处于[left,right)当中
    // 3 3 3 5 1 2 3
    //如果 a[mid] > a[right] 代表当前这个mid 一定是处在 左侧的排序数列中，最小值肯定不会是在这边 left = mid + 1;
    //如果 a[mid] < a[right] 代表这个mid 一定是处在右侧的排序数组中有可能这个mid 就是最小值 right = mid;
    //如果 a[mid] == a[right] 我们分辨不出处于那边，但是我们可以缩小范围 right = right-1；即使right是最小值，我们也有a[mid]替代

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            int mid = (left + right)/2;
            if (nums[mid] > nums[right]){
                left = mid + 1;
            }else if (nums[mid] < nums[right]){
                right = mid;
            }else {
                right = right-1;
            }
        }
        return nums[left];
    }

    /**
     * 搜索旋转排序数组的给定值
     * 返回下标
     * @param a
     * @param target
     * @return
     */
    public int search(int[] a, int target) {
        int left = 0;
        int right = a.length-1;
        //分情况 如果 mid = (left + right)/2 a[mid] > tagert
        //核心情况还是二分法，通过不断的二分缩短区间
        // 3 4 5 0 1 2
        while (left < right){
            int mid = (left + right) /2;//
            //先要判断当前的mid在那个区间
            if (a[mid] == target)
                return mid;
            if (a[mid] > a[a.length-1]){
                //当前在左递增序列如 3 4 5
                if (a[mid] > target){
                    if (a[0] > target){
                        left = mid +1;
                    }else {
                        right = mid -1;
                    }
                }else {
                    left = mid;
                }
            }else {
                //当前在右递增序列如 3 4 5
                if (a[mid] > target){
                    right = mid - 1;
                }else {
                    if (a[a.length-1] >= target) {
                        left = mid +1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        return a[left] == target? left:-1;
    }






}
