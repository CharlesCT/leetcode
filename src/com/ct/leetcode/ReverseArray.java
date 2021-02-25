package com.ct.leetcode;

/**
 * Created by CT on 2021/2/24.
 */
public class ReverseArray {

    /**
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     * 搜索target，否则返回-1
     */
    public int search(int[] nums, int target) {
        //已知当前的数组是有序的
        int left = 0;
        int right = nums.length-1;
        if (nums[left] < nums[right]){
            return nums[left];
        }

        while (left <= right){
            int mid = (left + right)/2; //
            //说明当前的这个数组
            //说明mid这个节点还是升序数组
            if (nums[mid] == target)
                return mid;
            //说明0 -mid是有序的
            if (nums[left] <= nums[mid]){
                //说明target 再 0 -mid-1之间
                if (nums[mid] > target && nums[left] <= target){
                    right = mid-1;
                }else {
                    left = mid +1;
                }
            }else {
                if (nums[mid] <target && target<=nums[right]){
                    left = mid +1;
                }else {
                    right = mid-1;
                }
            }
        }
        return nums[left];
    }


    /**
     * 如果是升序排列的 且带有重复的
     * @param nums
     * @param target
     * @return
     */
    public boolean search_double(int[] nums, int target) {
        //已知当前的数组是有序的
        if (nums == null || nums.length == 0)
            return false;
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = (left + right)/2; //
            if (nums[mid] == target)
                return true;
            if (nums[left] == nums[mid]){
                left++;
                continue;
            }
            //说明当前的这个数组
            //如果 是 [1,0,1,1,1] 这种数组 无法区分出这个 0-mid 是一个有序的
            if (nums[0] < nums[mid]){
                //说明target 再 0 -mid-1之间
                if (nums[mid] > target && nums[0] <= target){
                    right = mid + 1;//这里把mid保留，因为它可能是一个解
                }else {
                    left = mid +1;//抛弃这个值
                }
            }else  if (nums[0] > nums[mid]){
                if (nums[mid] < target && target <= nums[nums.length-1]){
                    left = mid +1;
                }else {
                    right = mid-1;
                }
            }else {
                left ++;
            }
        }
        return false;
    }


    /**
     * 搜索旋转数组的最小值
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int left = 0;
        int right = nums.length-1;
        //最小值有什么特点，
        if (nums[left] < nums[right])
            return nums[left];
        while (left < right){
            int mid = (left+right)/2;
            if (nums[mid] > nums[mid + 1] ) {
                //这个点就是拐点
                return nums[mid + 1];
            }else if (nums[mid-1] > nums[mid] ){
               return nums[mid];
            } else if (nums[mid] > nums[left]){
                //mid - left ;//是一个递增序列
                left = mid + 1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }


    /**
     * 搜索旋转数组的最小值
     * 且数组中的数据有重复
     * 还是同样的思路去寻找拐点的时候 可能会出现一个问题
     * 如果是[1,1]这种模式，不存在拐点 根本找不到
     */
    public int findMin_double(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int left = 0;
        int right = nums.length-1;
        //如果是有序的 直接就返回了
        if (nums[left] < nums[right])
            return nums[left];
        while (left < right){
            int mid = (left+right)/2;
            //已经有序了 直接返回
            if (nums[left] < nums[right])
                return nums[left];
            if (nums[mid] > nums[left]){
                // 789 123 说明落在 789 这边了，抛弃
                left = mid +1;
            }else if (nums[mid] == nums[left]){
                //分别不出 落在naer了 即使是num[left] 是一个最小值 我们也有num[mid] 与它相等
                left++;
            }else {
                //如果nus[left] > nums[mid] 有可能 num[mid] 就是最小值， 我们应该保留
                right = mid;
            }
        }
        return nums[left];
    }

    //求旋转数组的中位数

    /**
     * 寻找旋转数组的中位数
     * //假设数组中的数都是不重复的
     * //如果是奇数
     * //中位数肯定是 最小值的下标 + lengt/2 % lengt
     * //如果是偶数中位数肯定是 (最小值的下标 + leng/2)% length
     *
     * @param nums
     * @return
     */

    public int findMiddle(int[] nums){
        if (nums.length == 1)
            return nums[0];
        int left = 0;
        int right = nums.length-1;
        if (nums[left] < nums[right]){
            return getMiddle(nums,left);
        }
        while (left < right){
            if (nums[left] < nums[right]){
                return getMiddle(nums,left);
            }
            int mid = (left + right)/2;
            if (nums[mid] > nums[mid+1]){
                return getMiddle(nums,mid+1);
            }
            if (nums[mid] < nums[mid-1]){
                return getMiddle(nums,mid);
            }
            if (nums[mid] > nums[left]){
                left = mid+1;
            }else {
                right = mid -1;
            }
        }
        return -1;
    }

    public int getMiddle(int [] nums,int first){
        int n = nums.length;
        if (nums.length % 2 == 0){
            return (nums[(first+ n/2) % n] + nums[(first+n/2 -1) % n])/2;
        }else {
            return nums[(first+ n/2) % n];
        }
    }


    /**
     * 如果是在重复的数组里面去找。
     * 不能通过找拐点的形式了
     *必须我们要考虑[1,1,1,1,1,1]这种情况
     * 所以我们尽可能的去抛弃右边的数字
     */
    public int findMiddle_double(int nums[]){
        if (nums.length == 1)
            return nums[0];
        int left = 0;
        int right = nums.length-1;
        if (nums[left] < nums[right])
            getMiddle(nums,left);
        while (left < right){
            int mid = (left + right)/2;
            if (nums[left] < nums[right])
                getMiddle(nums,left);
            if (nums[mid] > nums[right]){
                left = mid +1;
            }else if (nums[mid] < nums[right]){
                right = mid;//有可能这个mid就是最小值
            }else {
                right--;//因为num[right] = nums[mid] 即使抛弃right 也有mid代替
            }
        }
        return getMiddle(nums,left);
    }






}
