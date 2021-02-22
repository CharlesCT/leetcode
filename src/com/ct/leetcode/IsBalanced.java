package com.ct.leetcode;

/**
 * 判断一棵树是都是平衡二叉树
 * 平衡二叉树他的左右孩子的高度都不会超过1，
 * 并且左右孩子也是分别都是平衡二叉树
 */
public class IsBalanced {


    private boolean ret = true;
    /**
     * 是否是平衡二叉树
     * 这里每次都要去求高度？
     * 效率肯定非常差
     * 我们应该思考一下
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        getHeight(root);
        return ret;
    }

    //求二叉树的高度
    public int getHeight(TreeNode root){
        if (root == null || !ret)
            return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) >= 1)
            ret = false;
        return Math.max(leftHeight,rightHeight) +1;
    }








}
