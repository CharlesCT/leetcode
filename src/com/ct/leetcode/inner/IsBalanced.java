package com.ct.leetcode.inner;

import com.ct.leetcode.TreeNode;

/**
 * Created by CT on 2021/4/23.
 */
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        return findH(root) != -1;

    }

    public int findH(TreeNode root){
        if (root == null)
            return 0;
        int leftHeight = findH(root.left);
        int rightHeight = findH(root.right);
        if (leftHeight == -1 || rightHeight == -1)
            return -1;
        if (Math.abs(rightHeight - leftHeight)>1){
            return -1;
        }
        return Math.max(leftHeight , rightHeight) +1;
    }











}
