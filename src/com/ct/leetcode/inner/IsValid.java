package com.ct.leetcode.inner;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by CT on 2021/5/11.
 */
public class IsValid {

    //判断是否是有效括号
    public boolean isValid(String s) {
        //先用hashmap保存
        if (s== null || s.length() <2)
            return false;

        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        //使用栈来做

        Stack<Character> stack = new Stack<>();
        stack.push('0');
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            } else {
                char temp = stack.peek();
                if (temp != '0' && temp == map.get(s.charAt(i))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.size() ==1;
    }
}
