package com.ct.leetcode.inner;

import com.ct.leetcode.TreeNode;

/**
 * Created by CT on 2021/5/17.
 */
public class IsCousins {


    int x;
    TreeNode xParent;
    private int xDepth;
    boolean xFound = false;

    int y;
    private int yDepth;
    private TreeNode yParent;
    boolean yFound = false;

    //判断x 和y是否是堂兄弟节点
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,0,null);
        return xDepth == yDepth && xParent != yParent;
    }

    public void dfs(TreeNode node, int depth, TreeNode parent) {
        if (node == null) {
            return;
        }

        if (node.val == x) {
            xParent = parent;
            xDepth = depth;
            xFound = true;
        } else if (node.val == y) {
            yParent = parent;
            yDepth = depth;
            yFound = true;
        }

        // 如果两个节点都找到了，就可以提前退出遍历
        // 即使不提前退出，对最坏情况下的时间复杂度也不会有影响
        if (xFound && yFound) {
            return;
        }

        dfs(node.left, depth + 1, node);

        if (xFound && yFound) {
            return;
        }

        dfs(node.right, depth + 1, node);
    }













}
