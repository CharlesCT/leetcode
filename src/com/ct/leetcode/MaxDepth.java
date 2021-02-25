package com.ct.leetcode;

/**
 *
 * 二叉树的最大深度
 */
public class MaxDepth {

    public int maxDepth (TreeNode root) {
        if (root == null)
            return 0;
        //寻找二叉树的最大深度

        return Math.max(maxDepth(root.left),maxDepth(root.right)) +1;
    }

}
