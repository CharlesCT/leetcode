package com.ct.leetcode;

import java.util.*;

/**
 * Created by CT on 2021/3/4.
 */
public class Tree {


    //根据层次遍历输出平衡二叉树的先序遍历。

    public List<Integer> findFirstOrder(int nums[]){
        //不需要重建二叉树
        //和堆一样 第一个非叶子节点就是 nums.lengt/2 -1;
        List<Integer> res = new ArrayList<>();
        if (nums.length == 1){
            res.add(nums[0]);
            return res;
        }
        //用来保存每一个节点的下标
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        int index = 0;
        queue.add(root);
        while (!queue.isEmpty()){
            //访问左孩子 自己 右孩子 通过下标来找寻左孩子右孩子
            TreeNode node = queue.poll();
            if (2 * index + 1 < nums.length){
                node.left = new TreeNode(2 * index + 1);
                queue.add(node.left);
            }
            if (2 * index +1 < nums.length){
                node.right = new TreeNode(2*index +2);
                queue.add(node.right);
            }
            index ++;
        }
        //输出先序遍历
        while (!queue.isEmpty() || root!=null){
            while (root != null){
                queue.addLast(root);
                res.add(root.val);
                root = root.left;
            }
            root = queue.poll();
            root = root.right;
        }
        return res;
    }


    /**
     * 二叉树的先序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
         Deque<TreeNode> queue = new LinkedList<>();//这里可以使用栈来做
        while (!queue.isEmpty() || root != null){
            while (root != null){
                queue.addLast(root);
                res.add(root.val);
                root = root.left;
            }
            root = queue.pollLast();
            if (root.right != null)
                root = root.right;
            else
                root = null;
        }
        return res;
    }


    //实现一个二叉树的后序遍历,递归实现
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        postorderTraversal(root,res);
        return res;
    }


    public void postorderTraversal(TreeNode root,List<Integer> res){
        if (root == null)
            return;
        //后序遍历
        postorderTraversal(root.left,res);
        postorderTraversal(root.right,res);
        res.add(root.val);
    }

    /**
     * 非递归我们可以考虑通过栈来实现，还是先去
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal_two(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);//入队，一直找左孩子
                root = root.left;
            }
            root = stack.peek();
            if (root.right == null || pre == root.right){
                //右孩子已经被访问过了,把自己加入结果
                res.add(root.val);
                stack.pop();
                pre = root;
                root = null;
            }else {
                root = root.right;
            }
        }
        return res;
    }




    //实现二叉树的中序遍历，非递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }




























}
