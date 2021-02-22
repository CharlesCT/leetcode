package com.ct.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个相交链表的第一个相交节点
 * leetcode 160
 */
public class IntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while (temp1 != temp2){
            temp1 = temp1 == null? headB:temp1.next;
            temp2 = temp2 == null? headA:temp2.next;
        }
        return temp1;
    }

}
