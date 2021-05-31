package com.ct.leetcode.offer;

import com.ct.leetcode.Tree;
import com.ct.leetcode.TreeNode;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by CT on 2021/4/15.
 */
public class Thief {

    public int thief(int nums[]){
        //用dp[i]来表示小偷走到i家的最大值
        if (nums.length <=1)
            return nums[0];
        //偷和不偷呗
        //很容易得到公式 dp[i] = max(dp[i-1],dp[i-2] + nums[i])
        //但是！！！！由于首位相连，！
        //这里就得转换思路了
        //如果偷第一个 我们偷的范围变成了 0-n-1
        //如果不偷第一个 范围变成 1-n
        //靠！！！！脑筋急转弯
        return Math.max(findMax(0,nums.length-1,nums),findMax(1,nums.length,nums));
    }

    //写出不头尾相连的方程
    public int findMax(int start, int end, int nums[]) {
        if (end - start <= 1)
            return nums[start];
        //不熟悉可以用dp数组
        int length = end - start;
     /*   int dp[] = new int[length];*/
        int dp_pre_two = nums[start];
       // dp[0] = nums[start];//没得说，只有你一家偷了就完事了
        //dp[i] = max(dp[i-1],dp[i-2] + nums[i])
        int dp_pre_one = Math.max(dp_pre_two, nums[start+1]);
        for (int i = 2; i < length; i++) {
            int temp = dp_pre_one;
            dp_pre_one = Math.max(dp_pre_one, dp_pre_two + nums[start + i]);
            dp_pre_two = temp;
        }
        return dp_pre_one;
    }





    //二叉树的打家
    //暴力法
    //层次遍历
    //
    public int rob(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            int sum = 0;
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                sum+=node.val;
            }
            System.out.print(sum);
            res.add(sum);
        }
        if (res.size() <=1)
            return res.get(0);
        //不熟悉可以用dp数组
        int length = res.size();
     /*   int dp[] = new int[length];*/
        int dp_pre_two = res.get(0);
        // dp[0] = nums[start];//没得说，只有你一家偷了就完事了
        //dp[i] = max(dp[i-1],dp[i-2] + nums[i])
        int dp_pre_one = Math.max(dp_pre_two, res.get(1));
        for (int i = 2; i < length; i++) {
            int temp = dp_pre_one;
            dp_pre_one = Math.max(dp_pre_one, dp_pre_two + res.get(i) );
            dp_pre_two = temp;
        }
        return dp_pre_one;

    }








}
