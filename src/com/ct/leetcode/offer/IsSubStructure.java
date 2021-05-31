package com.ct.leetcode.offer;

import com.ct.leetcode.TreeNode;
import java.util.Stack;

/**
 * 这里是两个结构
 */
public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null)
            return false;
        //找到起点，开始遍历
        //找到了一个起点，从这个起点开始遍历
        return findStart(A,B);
    }


    //只找一次就可以吗？
    //肯定还有一些不能找的啊
    //通过非递归遍历每次都去比较一下

    public boolean findStart(TreeNode A,TreeNode B){
        Stack<TreeNode> stack = new Stack<>();
        while (A!= null || !stack.isEmpty()){
            while (A!=null){
                stack.push(A);
                A = A.left;
            }
            //出栈
            A = stack.pop();
            if (A.val == B.val){
                boolean result = isCommon(A,B);
                System.out.println("common A is: " + result);
                if (result)
                    return true;
            }
            A = A.right;
        }
        return false;
    }


    //找到这个数的起点
    public boolean isCommon(TreeNode A,TreeNode B){
        //遍历
        if (B == null)
            return true;
        if (A == null)
            return false;
        if (A.val != B.val){
            return false;
        }
        boolean left = isCommon(A.left,B.left);
        boolean right = isCommon(A.right,B.right);


        return left && right;
    }




}
