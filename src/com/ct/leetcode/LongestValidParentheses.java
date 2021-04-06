package com.ct.leetcode;

import java.util.Stack;

/**
 * leetcode 32最长有效括号
 */
public class LongestValidParentheses {


    /**
     * 最长的有效括号()
     * 我们怎么做呢，
     * @param s
     * 用之前思考有效括号的方案，我们使用栈来做
     * 对输入的每一个字符下标为i都进行入栈操作，
     * 一旦碰到“）”我们应该出栈进行匹配，如果能匹配
     * 这时候的长度及应该是 i - 栈顶的元素的下标
     * 这里可能会难以理解为什么是栈顶的下标？
     * 比如：（）()。比如出现这种类似的结构，
     * 每次我们遇到“）”进行出栈的时候，栈内都是空的，
     * 栈内都是空代表了从0——i这所有的括号都被匹配过了！
     * 不是吗?不然我的栈为什么为空，为空就代表了之前入栈的所有元素都是被匹配过了！
     * 这时候我们的长度应该是 i - 0 +1。
     * 如果我们出栈的时候不会空，当前栈顶栈顶的元素下标为K，
     * 很明显K+1 —— i的元素都被匹配了 这时候我们的长度应该是
     * i -（k+1）+1 = i -k.
     * 开始写代码就很简单了
     *
     * @return
     */
    public int longestValidParentheses(String s) {
        if ( s == null ||s.length() == 0 || s.length() == 1)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                if (!stack.isEmpty()){
                    int index  = stack.peek();
                    if (s.charAt(index) == ')' ){
                        //配对成功
                        stack.pop();
                        max =Math.max(stack.isEmpty()?i+1:i - stack.peek(),max);
                    }else {
                        stack.push(i);
                    }
                }else {
                    stack.push(i);
                }
            }
        }
        return max;
    }

    /**
     * 还是可以改进的
     * 还是和求矩形最大面积的思路
     * 我们不想每次都去判断这个栈是不是null
     * 我们直接给这个栈加入-1，代表它为空
     * @param s
     * @return
     */
    public int longestValidParentheses_new (String s){

        if ( s == null ||s.length() == 0 || s.length() == 1)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(i);
            } else {
                int index = stack.peek();
                if (index > -1 && s.charAt(index) == '(') {
                    //配对成功
                    stack.pop();
                    max = Math.max(i - stack.peek(), max);
                } else {
                    stack.push(i);
                }
            }
        }
        return max;
    }


    //还有一种解法子
    //使用left 和right 用来记录“（”和右括号数“）”
    //如果left == right 所以有最大值这时候最大值应该是 2*left
    //如果left>right left 和right归零
    //但是这种无法求出“（（）这种的数量













}
