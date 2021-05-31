package com.ct.leetcode;

/**
 * Created by CT on 2021/4/8.
 */
public class TreeParent {


    /**
     * 查找两个几点 p，q的最近公共父节点
     * 注意 p可能会包含q， q也可能会包含p
     * 比如    p
     *       /   \
     *      t     q
     *这种怎么分析？ 这种没做过肯定做不出来
     * @return
     */
    public TreeNode findLastParent(TreeNode root,TreeNode p,TreeNode q){
        //找到就其中一个就停止
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = findLastParent(root.left,p,q);
        TreeNode right = findLastParent(root.right,p,q);
        if (left == null && right == null)
            return null;
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }


}
