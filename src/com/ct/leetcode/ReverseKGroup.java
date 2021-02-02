package com.ct.leetcode;

/**
 * Created by CT on 2021/2/2.
 */

/**
 * 对一个链表进行每K个一组进行反转
 */
public class ReverseKGroup {


    /**
     * 如果一组一组的循环做，可能会很繁琐
     * 我们可以用递归来做
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        for (int i = 1; i < k; i++) {
            if (head == null){
                return temp;
            }
            head = head.next;
        }
        //不满K个节点，直接返回保持原来的序列
        if (head == null)
            return temp;
        //保存K之后的下一个节点
        ListNode next = head.next;
        //开始反转
        ListNode pre = null;
        head = temp;
        while (temp != next){
            ListNode n = temp.next;
            temp.next = pre;
            pre = temp;
            temp = n;
        }
        head.next = reverseKGroup(next, k);
        //开始递归
        return pre;
    }


}
