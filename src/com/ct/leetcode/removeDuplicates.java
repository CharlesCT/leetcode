package com.ct.leetcode;

/**
 * Created by CT on 2021/4/6.
 */
public class RemoveDuplicates {

    /***
     * 原地删除数组中的重复项
     * 要求0(1）额外空间条件下完成
     * @param nums
     * @return
     * //已经按升序排序了。。。
     */
    public int removeDuplicates(int[] nums) {
        //原地删除
        //怎么原地删除呢
        //思考一哈
        //可能会出现很多次！
        //怎么去判断生成很多次呢
        if (nums.length == 0 || nums.length <=2)
            return nums.length;
        int count = 1;
        int current = nums[0];
        int pre = 0;
        //设计到数组移动的问题啊。
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] ==  current ){
                count++;
                if (count >= 3){
                    //标记需要删除的点
                   pre++;
                }else {
                    if (pre > 0 ){
                        //当前移动
                        nums[i-pre] = nums[i];
                    }
                }
            }else{
                if (pre >0 ){
                    //当前移动
                    nums[i-pre] = nums[i];
                }
                //不等了说明新的字符开始了
                count = 1;
                current = nums[i];
            }
        }
        return nums.length - pre;
    }


    //优雅写法快慢针
    //从这里开始去找
    //不好理解
    public int removeDuplicates_new(int[] nums) {
        if (nums.length <=2 )
            return nums.length;
        int fast = 2;
        int slow = 2;
        while (fast<nums.length){
            if (nums[slow-2] !=  nums[fast] ){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }


        return slow;
    }


    /***
     * 删除数组中重复的元素
     * 每个元素最多出现一次
     * @param nums
     * @return
     */
    public int removeDuplicates_2(int[] nums) {
        //还是按照我们刚刚的思路
        if (nums.length <=1)
            return nums.length;
        int slow = 1;
        int fast = 1;
        while (fast < nums.length){
            if (nums[slow-1] != nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }




}
