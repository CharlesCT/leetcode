package com.ct.leetcode;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by CT on 2021/2/19.
 */
public class SortListNode {


    /**
     *
     * @param head
     * @return
     *
     * 给定的是一个无序的链表
     * 要返回一个升序链表
     * 如果不需要额外的空间，而且时间复杂度需要0（nlongn)
     *考虑归并排序
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        //开始拆分,先找到中点
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow == null? null:slow.next;
        ListNode head1 = sortList(right);
        if (slow != null)
            slow.next = null;
        //分成两部分了
        ListNode head2 = sortList(head);
        //合并两个排序链表的问题了
        return  merge(head1,head2);
    }

    public ListNode merge(ListNode head1,ListNode head2){
        if (head1 == null || head2 == null)
            return head1== null? head2:head1;
        ListNode head = new ListNode();
        ListNode current = head;
        while (head1 != null && head2 != null){
            if (head1.val > head2.val){
                current.next = head2;
                head2 = head2.next;
            }else {
                current.next = head1;
                head1 = head1.next;
            }

            current = current.next;
        }
        current.next = head1 != null? head1:head2;
        return head.next;
    }


















}
