package com.ct.leetcode.offer;

import com.ct.leetcode.TreeNode;

/**
 * Created by CT on 2021/4/20.
 */
public class MaxDepth {

    //求出二叉树的深入
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left) ,maxDepth(root.right))+1;
    }
}
