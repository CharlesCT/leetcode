package com.ct.leetcode;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 * Created by CT on 2021/2/1.
 */
public class Test {
    public static void main(String[] args){

        List<List<Integer>> res = findSum(3);

        //输入的组合
     /*   System.out.println("-----------输入的是3--------------");
        for (int i = 0; i < res.size(); i++) {
            System.out.println("可能的组合有："+ list2String(res.get(i)) );
        }
        System.out.println("-----------输入的是5--------------");
        res = findSum(5);
        for (int i = 0; i < res.size(); i++) {
            System.out.println("可能的组合有："+ list2String(res.get(i)) );
        }*/

    /*    System.out.println("-----------输入的组合是 1，2，3--------------");
        int []arr1 = new int[]{1,1};

        System.out.println("结果是：---------》  " + monkey(arr1));
        System.out.println("-----------输入的组合是2,1,1,1,2,8--------------");

        arr1 = new int[]{2,1,1,1,2,8};
        System.out.println("结果是：---------》  " + monkey(arr1));
        arr1 = new int[]{1,1,1,1,1};
        System.out.println("-----------输入的组合是1,1,1,1,1--------------");
        System.out.println("结果是：---------》  " + monkey(arr1));

        System.out.println("-----------输入的组合是 1，4，3--------------");
        arr1 = new int[]{1,4,3};

        System.out.print("结果是：---------》  " + monkey(arr1));
*/

    /*    SolveNQueens queens = new SolveNQueens();
        queens.solveNQueens(4);*/
        Subsets subsets = new Subsets();
        subsets.subsets_new(new int[]{1,2,3});


    }

    private static String list2String(List<Integer> sum){

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sum.size(); i++) {
            res.append(sum.get(i) +",");
        }
        return res.toString();
    }




    //找出 所有1-n中所有组合为n的集合
    public static List<List<Integer>> findSum(int n){
        List<List<Integer>> res = new LinkedList<>();
        if (n == 0)
            return res;
        Stack<Integer> sum = new Stack<>();
        //使用回溯法子
        findSum(n,sum,n,res);
        return res;
    }
    public static void findSum(int tatget,Stack<Integer>sum,int n,List<List<Integer>> res){

        for (int i = 1; i <= n; i++) {
            //已经找到一组了
            if (tatget == 0){
                res.add(new ArrayList<>(sum));
                break;
            }else if (tatget < i){
                //后面找越找越大肯定无了
                break;
            }else {
                //加入集合
                sum.add(i);
                //target 减少I
                findSum(tatget-i,sum,n,res);
                //回溯
                sum.pop();
            }
        }
    }












    public static int monkey(int eats[]){
        //遇事不决先排序
        if (eats == null || eats.length == 0)
            return 0;
        //从小到大排序
        Arrays.sort(eats);
        //用一个dp数组来表示，dp[i]表示当前到这个猴子时候的剩余数量
        int [] dp = new int[eats.length];
        //很明显我们要倒推，因为最后一个猴子可以拿走所有的食物
        //我们希望这个猴子拿走的是刚好能吃饱的,我们让食量大的猴子后拿
        //为什么要食量大的后拿？考虑一个问题，如果胃口大的先拿，很有可能它立马就分走一半！，食量小的不容易分走一半
        int length = eats.length;
        dp[0] = eats[length-1];//最后一个给食量大的
        //这时候我们就要观察了！很重要！不然找不到的
        // 假设前一个猴子拿走 K
        //给下一个猴子留下了多少？
        // 是不是 remain -k 啊
        // 这个k = min(remin/2,2*eat)
        //所以我们得到 dp[i-1] = dp[i] - min(dp[i]/2,eat*2)
        //dp [i] = dp[i-1] + min(dp[i]/2,eat*2)
        //如果 dp[i]/2 比eat*2小则我们会得到 dp[i]/2 = dp[i-1]
        //dp [i] = dp[i-1] + min(dp[i-1],eat*2)
    /*    for (int i = 1; i < eats.length; i++) {
            dp[i] = Math.min(dp[i - 1] , 2 * eats[length - 1 - i]) + dp[i-1];
        }*/
        //还可以优化 不用dp,因为只有前后两个状态 skr
        int dp_sub =  eats[eats.length-1];
        for (int i = 1; i < eats.length; i++) {
            int k = dp_sub;
            //因为要求比他它需要加1
            if (dp_sub == eats[length - 1 - i]){
                k++;
            }
            dp_sub = Math.min(k , 2 * eats[length - 1 - i]) + dp_sub;
        }
        return dp_sub;
    }


    public static boolean check(int mid, int[] v) {
        for (int i = 0; i + 1 < v.length; i++) {
            int num = Math.min(mid / 2, v[i] * 2);
            if (num < v[i]) return false;
            mid -= num;
        }
        if (mid < v[v.length - 1]) return false;
        return true;
    }

   public static int checkMonkey(int v[]) {
        int l = 1 ;int  r = Integer.MAX_VALUE;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(mid,v)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
       return l;
    }













}
