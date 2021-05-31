package com.ct.leetcode.offer;

import com.ct.leetcode.TreeNode;

import java.util.*;

/**
 * Created by CT on 2021/4/22.
 */
public class LevelOrderII {


    //这里是进行层次遍历。
    //左右左右这种形式
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isAsc = false;
        Deque<Integer> children = new LinkedList<>();
        while (!queue.isEmpty()){
            int count = queue.size();
            children.clear();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (isAsc){
                    children.addLast(node.val);
                }else {
                    children.addFirst(node.val);
                }
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            isAsc = !isAsc;
            res.add(new ArrayList<>(children));
        }
        return res;
    }


}
