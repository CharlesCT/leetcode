package com.ct.leetcode;
import java.util.Stack;

/**
 * Created by CT on 2021/3/19.
 */
public class IsValidBST {


    //怎么判断一棵树是否是二叉搜索数
    //平衡二叉树， 左孩子小于根节点，且右孩子也是小于根节点的
    //很明显平衡二叉树的中序遍历是一个升序的
    //我们可以直接通过判断中序遍历是不是有序来做
    //直接使用非递归来做一个中序遍历
    public boolean isValidBST(TreeNode root) {
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //加入结果
            if (pre != null && pre.val >= root.val)
                return false;
            root = root.right ;
        }
        return true;
    }





}
