package com.ct.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * leetcode
 * 301
 * 删除无效括号
 */
public class RemoveInvalidParentheses {


    /**
     * 删除无效的括号
     * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
     返回所有可能的结果。答案可以按 任意顺序 返回。
     * @param s
     * @return
     * 输入: "()())()"
    输出: ["()()()", "(())()"]
     *
     */
    public List<String> removeInvalidParentheses(String s) {
        //我们可能会去深度优先搜索整个可能位置
        List<String > res = new LinkedList<>();
        if (s == null || s.length() == 0)
            return res;

        //我们需要先根据 左右括号的数量来确定最少删除的括号的数量
        int removeLeft = 0;
        int removeRight = 1;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '('){
                removeLeft ++;
            }else if (chars[i] == ')'){
                if (removeLeft>0){
                    removeLeft--;
                }else {
                    removeRight ++;
                }
            }
        }
        Set<String> set = new HashSet<>();
        findPath(0,0,0,new StringBuilder(),removeLeft,removeRight,chars,set);
        if (set.size() > 0)
            res.addAll(set);
        return res;
    }


    //深度搜索去查找所有可能删除的位置，
    //会出现重复的情况，比如 ((())  删除第一个位置和删除第二个位置产生的情况s是一样的
    //我们需要排除一些情况，剪枝操作
    //比如当我遍历路径中的左括号数"(" 一定要大于右括号数目的时候才有意义，这个路径往下走才有意义
    //比如（（（))))) 这时候右括号比左括号多了，这时候再往下走没有意义了。需要排除这种情况

    public void findPath(int index, int leftCount, int rightCount, StringBuilder path,int removeLeft, int removeRight, char[] chars, Set<String> set){
        if (index == chars.length){
            //走完了一条路了
            if (removeLeft == 0 && removeRight == 0){
                //加入集合
                set.add(path.toString());
            }
            return;
        }
        char character = chars[index];
        if (character == '(' && removeLeft > 0){
            //这个我们选择去掉这个括号.不加入路径里面,这时候遍历的左括号和右括号数量都没有变化
            findPath(index+1,leftCount,rightCount,path,removeLeft-1,removeRight,chars,set);
        }else if (character == ')' && removeRight > 0){
            findPath(index+1,leftCount,rightCount,path,removeLeft,removeRight-1,chars,set);
        }

        //我们还可以选择加入路径
        path.append(character);
        if (character != '(' && character != ')'){
            findPath(index+1,leftCount,rightCount,path,removeLeft,removeRight,chars,set);
        }else if (character == '('){
            findPath(index+1,leftCount+1,rightCount,path,removeLeft,removeRight,chars,set);
        }else if (rightCount < leftCount){
            findPath(index+1,leftCount,rightCount+1,path,removeLeft,removeRight,chars,set);
        }
        //回溯
        path.deleteCharAt(path.length()-1);
    }


















}
