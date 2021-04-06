package com.ct.leetcode;

/**
 * 寻找二叉树的最大路径和
 */
public class MaxPathSum {


    private int max = 0;

    //提出一个很有意思的概念
    //一个节点的贡献量
    //如果一个节点为空的,贡献度为O，如果一个节点

    public int max(TreeNode root){
        if (root == null)
            return 0;

        int left = Math.max(maxPathSum(root.left),0);
        int right = Math.max(maxPathSum(root.right),0);

        max = Math.max(left + right + root.val,max);
        return root.val + Math.max(left,right);
    }


    public int maxPathSum(TreeNode root) {
        max(root);
        return max;
    }

}
