package com.ct.leetcode;

/**
 *阿里巴巴真题
 */
public class FindKthToTail {

    //输入一个链表找到倒数第K个节点

    public ListNode findKthToTail (ListNode pHead, int k) {
        // write code here
        if (pHead == null || k == 0)
            return null;

        ListNode temp = pHead;
        for (int i = 0; i < k; i++) {
            if (temp == null)
                return null;
            temp = temp.next;
        }
        while (temp != null){
            pHead = pHead.next;
            temp = temp.next;
        }
        return pHead;
    }

}
