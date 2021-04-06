package com.ct.leetcode;

import java.util.Stack;

/**
 *leetcode 84,
 *
 *
 * 思考怎么才能求出最大矩形呢
 * 如果要求一个柱形图的最大矩形
 * 柱状图都是有高有低的
 * 如果是递增
 * 要求整个矩形的最大面积 我们应该从数组的第一个开始比较
 * 比如1 2  3 4 5
 * 数组的第一个元素是1，如果它可以被画成一个最大的矩形应该是
 * 他表示的最大矩形为 ： 5 * 1 = 5.把画到末尾就行了
 * 对于元素2来说，如果它能被画成一个最大矩形
 * 由于递增应该是 (5-1 )* 2 从他开始到数组末尾就可以了
 * 但是如果数组中参差不齐的元素。比如
 *
 * 2 3  1 4 5
 * 对于元素2 来说，如果它能被画成一个最大元素，则从它开始一直从右边找她最后一个不比他小的元素截至，找到元素3，
 * 则它能表示的最大矩形就是 2 * （1 - 0 +1） = 4
 * 对于元素1 来说就有点特别了
 * 元素1  它可以往左边找，也可以往右边找，从左边找一直找到 2（因为前面没有元素了，）往后找可以找到5（后面也没有元素了）
 * 如果 我们对每一个数进行查找，时间效率不高，太暴力了，
 * 还是借助我们递增性质，如果我们维护一个递增的序列，里面的数都比1 大，则如果要把1 加入整个序列里面，我们就需要对它进行排列，
 * 这里就是我们要求的1在最左边的位置了，1加入之后，如果在加入的元素都比1大，则1在最右边的位置+1，如果比1小，则1的最右边的位置
 * 也找到了。
 *
 *
 *
 */
public class LargestRectangleArea {




    public int largestRectangleArea(int[] heights) {
        if (heights==null || heights.length == 0)
            return 0;
        if (heights.length == 1)
            return heights[0];
        //首先要维护一个元素位置i的左右边界
        int [] left = new int [heights.length];
        int [] right = new int[heights.length];
        //需要维护一个递增序列使用栈来做
        Stack<Integer> stack = new Stack<>();
        //假设每一个右边界都是数组的末尾
        for (int i = 0; i < right.length; i++) {
            right[i] = heights.length;
        }
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty()&& heights[stack.peek()] > heights[i]){
                right[stack.pop()] = i;
            }
            //找到最左边的位置了
            left[i] = stack.isEmpty()?-1:stack.peek();
            //加入栈
            stack.push(i);
        }
        //开始计算最大值了
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max((right[i] - left[i]-1) * heights[i],max);

        }
        return max;
    }







}
