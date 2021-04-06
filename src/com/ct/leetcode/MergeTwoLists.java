package com.ct.leetcode;

/**
 * leetcode 简单的题目
 */
public class MergeTwoLists {


    //递归方法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return  l1 == null?l2:l1;
        if (l1.val <l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists_new(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        ListNode node = new ListNode();
        ListNode current = node;
        while (l1!=null && l2!=null){
            if (l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            }else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = l1 == null?l2:l1;
        return node.next;
    }




}
