package com.ct.leetcode;

import java.util.ArrayList;

/**
 * 合并K个有序链表
 */
public class MergeKLists {
    //方法一、循环合并
    //方法二、分治合并 不断拆分
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists==null || lists.size() == 0)
            return null;
        if (lists.size() == 1)
            return lists.size() ==0?null:lists.get(0);
        return mergeKLists(lists,0,lists.size()-1);
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists,int left ,int right){
        if (left >= right)
            return lists.get(left);
        int mid = (left + right)/2;
        //开始分治
        ListNode p1 = mergeKLists(lists,left,mid);
        ListNode p2 = mergeKLists(lists,mid+1,right);
        //开始合并
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (p1 != null && p2!=null){
            if (p1.val > p2.val){
                current.next = p2;
                p2 = p2.next;
            }else {
                current.next = p1;
                p1 = p1.next;
            }
            current = current.next;
        }
        current.next = p1==null?p2:p1;
        return head.next;
    }













}
