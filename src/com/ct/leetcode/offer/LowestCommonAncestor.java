package com.ct.leetcode.offer;

import com.ct.leetcode.TreeNode;

/**
 * Created by CT on 2021/4/20.
 */
public class LowestCommonAncestor {

    /**
     * 二叉树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ( root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left == null && right == null)
            return null;
        else if (left != null && right !=null)
            return root;
        else
            return left == null?right:left;
    }
}
