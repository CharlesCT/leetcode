package com.ct.leetcode;

import java.util.Stack;

/**
 * 使用栈来实现队列
 */
public class StackForQueue {


    // 用栈来实现队列，队列是先进先出的
    //栈是先进后出的
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        //先进后出
        //先把 stack1 放到stack2 中
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }


}
