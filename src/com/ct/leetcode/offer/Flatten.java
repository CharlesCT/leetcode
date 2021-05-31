package com.ct.leetcode.offer;

import com.ct.leetcode.Tree;
import com.ct.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by CT on 2021/5/11.
 */
public class Flatten {

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        //二叉树展开为链表
        //用非递归的方式来做
        TreeNode current = null;
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                queue.add(root);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        root = null;
        //连起来
        while (!queue.isEmpty()){
            if (root == null){
                root = queue.poll();
                current = root;
                root.left = null;
            }else {
                current.right = queue.poll();
                current.left = null;
                current = current.right;
            }
        }
    }

    //用递归的方式做呢
    public void flatten_new(TreeNode root){

        if (root == null)
            return;
        firstIndex(root);
    }

    public TreeNode firstIndex(TreeNode root){
        if (root == null)
            return null;
        TreeNode left = firstIndex(root.left);
        //这里不行right 导致截断
        root.left = null;
        TreeNode end = left;
        while (end != null && end .right != null){
            end = end.right;
        }
        if (left != null)
            end.right = firstIndex(root.right);
        else {
            left = firstIndex(root.right);
        }
        root.right = left;
        return root;
    }

    //再来一个展开式，把节点保存住就行了
    //我们刚刚不能直接把右孩子赋值为左孩子，因为会造成丢失。


    public void flatten_new2(TreeNode root){
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = null;
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (pre != null){
                pre.left = null;
                pre.right = temp;
            }
            if (right!=null){
                stack.push(right);
            }
            if (left != null){
                stack.push(left);
            }
            pre = temp;
        }

    }






}
