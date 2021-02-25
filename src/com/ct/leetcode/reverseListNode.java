package com.ct.leetcode;

/**
 * Created by CT on 2021/2/23.
 */
public class ReverseListNode {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = null;//保存前部节点
        ListNode current = head;
        for (int i = 1; i < left; i++) {
            pre = current;
            current.next = head.next;
            current = current.next;
        }
        //从current开始反转
        ListNode newHead = null;
        ListNode end = current;
        for (int i = left; i <= right; i++) {
            ListNode temp = current.next;
            current.next = newHead;
            newHead = current;
            current = temp;
        }
        //把后续的节点连起来
        end.next = current;
        if (left != 1 && pre != null)
            pre.next = newHead;
        return left == 1 ? newHead:head;
    }
}
