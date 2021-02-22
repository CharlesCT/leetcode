package com.ct.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by CT on 2021/2/18.
 */
public class IsValid {

    /**
     *
     * @param s string字符串
     * @return bool布尔型
     * 判断括号是否合法
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s
     * 思路如果碰到一个向左边开口的字符，
     * 那么他的前一个字符肯定是与他匹配的左边开口的字符
     */
    public boolean isValid (String s) {

        // write code her
        //为了方便比较我们直接加入 key:）value:（ 这种hashmap
        //这样当我们碰到)这种左开口的时候
        //只需要判断 map.containsKey()就可以了 获取到的value就是与他匹配的右开口
        HashMap<Character,Character> hashMap = new HashMap<>();
        hashMap.put(')','(');
        hashMap.put('}','{');
        hashMap.put(']','[');
        // byte boolean float int short double char long
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            //开始
            if (hashMap.containsKey(temp)){
                if (stack.isEmpty())
                    return false;
                if (stack.peek() != hashMap.get(temp)){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(temp);
            }
        }
        return stack.isEmpty();
    }
}
