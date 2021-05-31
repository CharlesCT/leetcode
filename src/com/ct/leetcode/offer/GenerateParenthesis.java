package com.ct.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 *括号的生成
 */
public class GenerateParenthesis {

    //用回溯法来做吧

    public List<String> generateParenthesis(int n) {
        //获取当前的显示内容
        List<String> res = new ArrayList<>();
        findPath(0,0,n,res,new StringBuilder());
        return res;
    }


    public void findPath(int leftcount,int start,int n,List<String> res,StringBuilder path){
        System.out.println(path.toString());
        if (start == n && leftcount == 0){
            res.add(path.toString());
            return;
        }
        //选择左边，当左括号要和右括号保持数量相等才能继续添加左括号
        if (n - start > leftcount){
            path.append('(');
            findPath(leftcount+1,start+1,n,res,path);
            path.deleteCharAt(path.length()-1);
        }
        if (leftcount > 0){
            path.append(')');
            findPath(leftcount-1,start+1,n,res,path);
            path.deleteCharAt(path.length()-1);
        }
    }







}
