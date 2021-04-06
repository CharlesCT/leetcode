package com.ct.leetcode;

import java.util.List;

/**
 *给定一个无序链表
 * 返回一个升序链表
 * 怎么做？
 * 这个题如果没有去刷过
 * 反转链表 找到倒数第K个节点的题目
 * 你无法下手，链表的题目都是串联的
 * 简单的从 反转链表-》反转m-n链表 -》  合并两个有序链表
 * 判断链表是否有环 -》找到链表的相交节点。
 * 寻找链表的倒数第K个节点。加上归并排序的思想
 * 你才有可能写出来这个代码。
 * 只是有可能，因为许多边界情况。
 * 算法题都是连贯思维的
 * 靠背过不了多久就忘了。
 *
 */
public class SortLinkNode {


    /**
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head){
        //不用排序，就一个节点
        if (head == null || head.next == null)
            return head;

        //这时候要用到分治的思想了
        //我们再归并排序中，怎么实现排序的
        // 2 ,4,1,0,5,3
        // 我们先把数组分为一半
        //2 4 1 和 0 5 3
        //再分别把 2 4 1 和 0 5 3 再分为一半
        // 2 和 4 1。   0和 5 3
        //到最后不能再分了 变成一个个的了  {2 }{ 4}{ 1} { 0} { 5} {3}
        //这时候回溯进行合并
        //2和 4 合并 在和1 变成了 1 ，2，4了，再往上合并就会得到一个升序的数组了
        //链表也是一样的。
        //我们把链表不停的分割 ，直到不能分割为止
        //使用快慢针，这也是链表算法里面经常使用的
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast!= null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        //这时候我们的 slow 可以看作是中点
        // head -slow是一部分 slow。next -尾部是一部分
        ListNode first = sortList(slow.next);
        slow.next = null;
        //防止粘连重复
        ListNode second = sortList(head);
        //下面的工作就是合并两个有序链表了
        ListNode temp = new ListNode();
        ListNode current = temp;
        while (first != null && second != null){
            if (first.val < second.val){
                current.next = first;
                first = first.next;
            }else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }
        current.next = first == null? second:first;
        return temp.next;
    }






}
