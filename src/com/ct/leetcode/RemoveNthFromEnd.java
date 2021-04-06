package com.ct.leetcode;

/**
 * leetcode19
 * 删除数组的倒数第K个数字
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode current = head;
        for (int i = 0; i < n ; i++) {
            current = current.next;
        }
        if (current == null)
            return head.next;
        ListNode pre = head;
        ListNode temp = head;
        while (current != null){
            pre = temp;
            temp = temp.next;
            current = current.next;
        }
        pre.next = temp.next;
        temp.next = null;
        return head;
    }
}
