package com.ct.leetcode.offer;

import com.ct.leetcode.TreeNode;

/**
 * 镜像树
 */
public class MirrorTree {

    //请完成一个函数，输入一个二叉树，该函数输出它的镜像。

    /**
     *  4
     /   \
     2     7
     / \   / \
     1   3 6   9

       4
     /   \
     7     2
     / \   / \
     9   6 3   1
     *
     *
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = mirrorTree(root.left);
        root.left = mirrorTree(root.right);
        root.right = left;
        return  root;
    }



}
