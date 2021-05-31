package com.ct.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by CT on 2021/4/7.
 */
public class TreeToDoublyList {

    public TreeNode treeToDoublyList(TreeNode root) {

        if (root == null)
            return root;

        // 二叉搜索树的 中序遍历是有序的，这里要求是一个
        //有序的链表 得中序遍历
        //遍历模板
        // -->left
        //--root
        //--right
        //我们不用递归来做
        //非递归的有mirror方法(这个有点难以理解），和栈法
        //定义头部指针
        TreeNode head = null;
        TreeNode current = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null || !stack.isEmpty()){
            while (root != null){
                //一直找左孩子
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();//我们要记住第一次出栈的一个节点.这个就是头节点
            if (head == null){
                head = root;
                current = head;
            }else {
                //开始连起来
                current.right = root;
                root.left = head;
                current = current.right;
            }
            root = root.right;
        }
        //循环链表
        current.right = head;
        head.left = current;
        return  head;
    }













}
