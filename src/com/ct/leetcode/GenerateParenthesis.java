package com.ct.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CT on 2021/3/31.
 */
public class GenerateParenthesis {
    //n代表生成的
    public List<String> generateParenthesis(int n) {
        //用回溯来做吧
        List<String> res = new ArrayList<>();
        findPath(0,2 * n,0,new StringBuilder(),res);
        return res;
    }

    public void findPath(int start,int n,int leftcount,StringBuilder path,List<String> res){
        if (start == n && leftcount == 0){
            res.add(path.toString());
            return;
        }
        //选择"(",左边括号的数量不能大于右边括号的数量，不然就是无效的
        if (leftcount < n - start){
            path.append("(");
            findPath(start+1,n,leftcount+1,path,res);
            //回溯
            path.deleteCharAt(path.length()-1);
        }
        //只有左边括号的前提下才可以使用右边括号
        if (leftcount > 0){
            path.append(")");
            findPath(start+1,n,leftcount-1,path,res);
            //回溯
            path.deleteCharAt(path.length()-1);
        }
    }


}
