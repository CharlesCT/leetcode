package com.ct.leetcode.offer;

import com.ct.leetcode.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by CT on 2021/5/31.
 */
public class WidthOfBinaryTree {


    //二叉树的宽度
    //最左端和最右端的非空子节点之间的距离
    //如果在中间的空节点也是计算在内
    //对于每一层的节点我们都进行下标，
    //每一个节点都有深度和标号
    //同一层的节点，计算出序号的差值就行。
    //左孩子为 2*i，右孩子为 2*i+1 i为父节点的下标
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        //层次遍历来做
        Queue<IndexPathNode> queue = new LinkedList<>();
        queue.add(new IndexPathNode(0,0,root));
        //同一层的才去计算节点。
        int left = 0;
        int res = 0;
        int currentDepth = 0;
        while (!queue.isEmpty()){
            IndexPathNode node = queue.poll();
            if (node.node != null){
                //加入节点
                queue.add(new IndexPathNode(node.depth+1,2*node.index,node.node.left));
                queue.add(new IndexPathNode(node.depth+1,2*node.index +1,node.node.right));
                if (currentDepth != node.depth){
                    currentDepth = node.depth;
                    left = node.index;//起点
                    System.out.println(left);
                }
                res = Math.max(res,node.index -left+ 1);
            }
        }
        return  res;
    }


    class IndexPathNode{
        int index;
        int depth;
        TreeNode node;
        IndexPathNode(int depth,int index,TreeNode node){
            this.depth = depth;
            this.index = index;
            this.node = node;
        }

    }


    int ans = 0;
    //深度深度优先来做
    public int widthOfBinaryTree2(TreeNode root) {
        if (root == null)
            return 0;
        dfs(new HashMap<Integer, Integer>(),root,0,0);
        return ans;
    }



    public void dfs(HashMap<Integer,Integer> leftStart,TreeNode root,int depth, int position){
        if (root == null)
            return ;
        if (leftStart.get(depth) == null){
            leftStart.put(depth,position);
        }
        ans = Math.max(ans,position - leftStart.get(depth) +1);
        dfs(leftStart,root.left,depth+1,position *2);
        dfs(leftStart,root.right,depth+1, position *2 +1);
    }













}
