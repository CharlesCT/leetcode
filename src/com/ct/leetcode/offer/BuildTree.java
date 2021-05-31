package com.ct.leetcode.offer;

import com.ct.leetcode.Tree;
import com.ct.leetcode.TreeNode;

/**
 * 生成二叉树
 */
public class BuildTree {

    //递归法
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
       return buildTree(preorder,inorder,0,0,inorder.length-1);
    }


    /**
     * 编译当前这棵树
     * @param preorder
     * @param inorder
     * @param start
     * 123
     * 123//中序遍历
     * @return
     */
    public TreeNode buildTree(int[] preorder,int[] inorder,int start,int begin,int end){

        if (start >= preorder.length)
            return null;
        if (begin > end)
            return null;
        if (end - begin == 0)
            return new TreeNode(inorder[begin]);
        int index = begin;
        while (index <=end){
            if (inorder[index] == preorder[start]){
                break;
            }
            index++;
        }
        TreeNode root = new TreeNode(inorder[index]);

        root.left = buildTree(preorder,inorder,start+1,begin,index-1);
        root.right = buildTree(preorder,inorder,start + index - begin+1,index+1,end);
        return root;
    }











}
