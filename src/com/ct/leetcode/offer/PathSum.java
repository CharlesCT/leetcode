package com.ct.leetcode.offer;

import com.ct.leetcode.Tree;
import com.ct.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 找出从根节点出发，存在子节点之和为target的路径
 */
public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> values = new ArrayList<>();
        int sum = 0;
        while (!stack.isEmpty() || root!=null){
            while (root!=null){
                stack.push(root);
                sum += root.val;
                if (sum == target){
                    res.add(new ArrayList<>(values));
                }
                values.add(root.val);

                root = root.left;
            }
            root = stack.pop();
            if (root.right == null){
                sum -= root.val;
                values.remove(values.size()-1);
            }
            root = root.right;
        }
        return res;
    }

    //递归求解
    public List<List<Integer>> pathSum_new(TreeNode root, int target) {

        List<List<Integer>> res = new ArrayList<>();
        findPath(root,target,0,new ArrayList<Integer>(),res);
        return res;

    }

    //我们去递归求解

    public void findPath(TreeNode root,int target,int sum,List<Integer>values,List<List<Integer>> res){
        if (root == null)
            return;
        sum += root.val;
        values.add(root.val);
        if (sum == target && root.right == null && root.left == null){
            res.add(new ArrayList<>(values));
        }
        findPath(root.left,target,sum,values,res);
        findPath(root.right,target,sum,values,res);
        values.remove(values.size()-1);
    }




}
