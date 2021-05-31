package com.ct.leetcode.offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by CT on 2021/5/28.
 */
public class TopKFrequent {
    //给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
    public int[] topKFrequent(int[] nums, int k) {
        //找出高频元素
        //使用堆排序

        //定义map 统计出现的次数
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count+1);
        }
        //用数组来做堆排序
        Map.Entry<Integer,Integer>[] tables = new Map.Entry[map.size()];
        Iterator<Map.Entry<Integer,Integer>> set = map.entrySet().iterator();
        int index = 0;
        while (set.hasNext()) {
            tables[index++] = set.next();
        }
        int length = tables.length;
        //建立起大根堆
        for (int i = length/2 -1; i >=0 ; i--) {
            adjustHeap(tables,length,i);
        }
        //第一个元素必定是最大的
        int [] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = tables[0].getKey();
            tables[0] = tables[length-i-1];
            adjustHeap(tables,length-i-1,0);
        }
        return res;

    }
    public void adjustHeap(Map.Entry<Integer,Integer>[] tables,int end,int i){
        Map.Entry<Integer,Integer> temp = tables[i];
        for (int j = 2 * i+1; j < end ; j = 2* j +1) {
            if (j+1 < end && tables[j+1].getValue() > tables[j].getValue())
                j++;
            if (tables[j].getValue() > temp.getValue()){
                tables[i] = tables[j];
                i = j;
            }
        }
        tables[i] = temp;
    }










}
