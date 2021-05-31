package com.ct.leetcode.offer;

import com.ct.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by CT on 2021/4/18.
 */
public class LevelOrder {

    //从头到下打印二叉树
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> integers = new ArrayList<>();
        while (!queue.isEmpty()){
            root = queue.poll();
            integers.add(root.val);
            if (root.left != null)
                queue.add(root.left);
            if (root.right != null)
                queue.add(root.right);
        }
        int [] result = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            result[i] = integers.get(i);
        }
        return result;
    }




}
