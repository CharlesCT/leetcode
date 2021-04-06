package com.ct.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by CT on 2021/4/1.
 */
public class EvalRPN {

    //逆波兰表达式
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return 0;
        //先入栈
        int res = 0;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String op = tokens[i];
            if (op.equals("+")){
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                res = a + b;
                stack.push(String.valueOf(res));
            }else if (op.equals("-")){
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                res =  a -b;
                stack.push(String.valueOf(res));
            }else if (op.equals("/")){
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                res =  a/b;
                stack.push(String.valueOf(res));
            }else if (op.equals("*")){
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                res =  a*b;
                stack.push(String.valueOf(res));
            }else {
                res = Integer.parseInt(op);
                stack.push(op);
            }
        }
        return res;
    }
}
