package com.ct.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * TOPKen的问题
 */
public class TopKFrequent {

    //堆排序，自己建立堆来做
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 ){
            return new int[k];
        }
        int[] res = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        //用数组来做堆排序
        Map.Entry<Integer,Integer>[] tables = new Map.Entry[map.size()];
        Iterator<Map.Entry<Integer,Integer>> set = map.entrySet().iterator();
        int index = 0;
        while (set.hasNext()) {
            if (tables[index]!=null)
                System.out.print(tables[index].getKey());
            tables[index++] = set.next();
        }
        index = map.size();
        //建立堆 .第一个叶子节点
        for (int i = index/2 -1; i >=0 ; i--) {
            adjustHeap(i,index,tables);
        }
        for (int i = 0; i < index; i++) {
            System.out.println("table is" + tables[i].getKey());
        }
        for (int i = 0; i < k; i++) {
            //数组的第一个位置永远为当前的值
            res[i] = tables[0].getKey();
            //和最后一个交换
            tables[0] = tables[index-i-1];
            adjustHeap(0,index-i-1,tables);
            //调整堆
        }
        return res;
    }

    //最大根堆
    public void adjustHeap(int i,int end,Map.Entry<Integer,Integer>[] tables){
        Map.Entry<Integer,Integer> temp = tables[i];
        for (int j = 2*i+1; j < end; j = 2 * j+1) {
            if (j +1 <end && tables[j+1].getValue() > tables[j].getValue()){
                j++;
            }
            if (tables[j].getValue() > temp.getValue()){
                //交换位置
                tables[i] = tables[j];
                i = j;
            }
        }
        tables[i] = temp;
    }

















}
