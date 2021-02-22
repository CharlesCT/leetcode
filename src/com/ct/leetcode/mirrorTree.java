package com.ct.leetcode;

/**
 * Created by CT on 2021/2/20.
 */
public class MirrorTree {

    //二叉树的镜像
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null )
            return root;
        //镜像的意思是左右节点都要替换
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        //交换左右孩子
        root.left = right;
        root.right = left;
        return root;
    }



}
