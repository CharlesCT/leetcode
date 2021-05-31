package com.ct.leetcode.offer;

/**
 * Created by CT on 2021/4/23.
 */
public class GetLeastNumbers {

    //自建堆来做吧
    public int[] getLeastNumbers(int[] arr, int k) {
        int []result = new int[k];
        buildHeap(arr);
        for (int i = 0; i < k ; i++) {
            result[i] = arr[0];
            swap(0,arr.length-1-i,arr);
            adjustHeap(0,arr.length-i-1,arr);
        }
        return result;
    }

    public  synchronized void swap(int a,int b,int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public void buildHeap(int []arr){
        int length = arr.length;
        for (int i = length/2-1; i >=0; i--) {
            adjustHeap(i,length,arr);
        }
        //小根推
    }

    public void adjustHeap(int start,int end,int[]arr){
        int temp = arr[start];
        for (int i = 2*start+1; i  < end; i = 2 * i + 1) {
            if (i+1<end && arr[i+1] < arr[i]){
                i++;
            }
            if (arr[i] < temp){
                arr[start] = arr[i];
                start = i;
            }
        }
        arr[start] = temp;
    }

















}
