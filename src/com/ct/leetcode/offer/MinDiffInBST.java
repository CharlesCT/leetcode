package com.ct.leetcode.offer;

import com.ct.leetcode.TreeNode;

import java.util.Stack;

/**
 * Created by CT on 2021/4/13.
 */
public class MinDiffInBST {
    //给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
    //二叉树的中序遍历是一个升序

    public int minDiffInBST(TreeNode root) {
        //非递归来做吧，使用栈
        if (root == null)
            return 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        int min = Integer.MAX_VALUE;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null){
                min = Math.min(min,root.val - pre.val);
            }
            pre = root;
            root = root.right;
        }
        return min;

    }
}
