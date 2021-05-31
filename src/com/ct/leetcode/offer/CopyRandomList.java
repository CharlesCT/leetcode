package com.ct.leetcode.offer;

import java.util.HashMap;

/**
 * Created by CT on 2021/4/28.
 */
public class CopyRandomList {



    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        //建立映射用hash表来做
        HashMap<Node,Node> hashMap = new HashMap<>();
        Node current = head;
        while (current != null){
            hashMap.put(current,new Node(current.val));
            current = current.next;
        }
        current = head;
        while (current != null){
            //next
            Node tempNode  = hashMap.get(current);
            tempNode.next = current.next == null? null:hashMap.get(current.next);
            tempNode.random = current.random == null?null:hashMap.get(current.random);
            current = current.next;
        }
        return hashMap.get(head);
    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
