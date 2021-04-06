package com.ct.leetcode;

import java.util.List;

/**
 * Created by CT on 2021/3/25.
 */
public class DeleteDuplicates {

    /**
     * 删除排序链表中的重复元素II
     * 需要返回同样升序的链表
     *
     * 思路
     *
     * @param head
     * @return
     */
    //122
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode current = head;
        ListNode pre;
        ListNode newHead = new ListNode();
        ListNode newNext = newHead;
        //开始搞
        while (current != null){
            //这里开始找啊
            pre = current;
            current = current.next;
            boolean duplicate = false;
            while (current != null){
                if (current.val == pre.val){
                    duplicate = true;
                }
                if (current.val != pre.val){
                    break;
                }
                current = current.next;
            }
            if ( !duplicate){
                //加入
                newNext.next = pre;
                pre.next = null;
                newNext = newNext.next;
            }

        }
        return newHead.next;
    }
}
