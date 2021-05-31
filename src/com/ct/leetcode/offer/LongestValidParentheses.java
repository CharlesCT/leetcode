package com.ct.leetcode.offer;

import java.util.Stack;

/**
 * Created by CT on 2021/5/10.
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int leftCount  = 0;
        int rightCount = 0;
        int res = 0;
        char [] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '('){
                //leftRemove 判断连续
                leftCount ++;
            }else {
                rightCount++;
            }
            if (leftCount == rightCount){
                res = Math.max(res,rightCount);
            }else if (rightCount > leftCount){
                leftCount = rightCount = 0;
            }

        }
        leftCount = rightCount = 0;
        for (int i = chars.length-1; i >=0 ; i--) {
            if (chars[i] == ')'){
                rightCount++;
            }else {
                leftCount++;
            }
            if (leftCount == rightCount){
                res = Math.max(res,leftCount);
            }else if (leftCount> rightCount){
                leftCount = rightCount = 0;
            }

        }
        return res * 2;
    }


    //用栈来做

    public int longestValidParentheses_new(String s){

        if (s == null || s.length() == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        stack.push(-1);
        //读到）就开始出战
        //记住下标来做
        //i - index 就代表了 index - i这一段都是匹配的
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '('){
                stack.push(i);
            }else {
                int index = stack.peek();
                if (s.charAt(index) == '(' && index > -1) {
                    stack.pop();
                    res = Math.max(i - stack.peek(),res);
                }else {
                   stack.push(i);
                }
            }
        }
        return res;
    }






}







