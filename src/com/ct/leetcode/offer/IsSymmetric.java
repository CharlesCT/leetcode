package com.ct.leetcode.offer;

import com.ct.leetcode.Tree;
import com.ct.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by CT on 2021/5/8.
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }

    public boolean check(TreeNode q,TreeNode p) {
        //判断一棵树是不是对称的
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return p.val == q.val && check(p.left,q.right) && check(p.right,q.left);
    }

    //层次遍历法

    public boolean isSymmetric_new(TreeNode root){
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        //遍历
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            if (p == null && q == null)
                continue;
            if (p == null || q == null || (p.val != q.val))
                return false;
            queue.add(p.left);
            queue.add(q.right);

            queue.add(p.right);
            queue.add(q.left);
        }

        return true;

    }





}
