package com.ct.leetcode;

/**
 *leetoce61旋转链表
 */
public class RotateRight {


    /**
     * 先判断长度
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        int length = 1;
        ListNode tail = head;
        while (tail.next != null){
            tail = tail.next;
            length++;
        }
        k = k % length;
        if (k == 0)
            return head;
        //先把头尾连起来
        tail.next = head;
        //找到length -k 的位置就完事了
        ListNode newHead = head;
        for (int i = 0; i < length - k-1; i++) {
            newHead = newHead.next;
        }
        head = newHead.next;
        newHead.next = null;
        return head;
    }








}
