package com.ct.leetcode.offer;

import java.util.HashMap;

/**
 * 实现一个LRU算法
 * 要保持着最近使用原则
 *如果我们的key 和value都是Node
 * 可以避免去寻找链表的过程
 */
public class LRUCache {

    private int capacity = 0;

    //声明一个头节点和 尾节点
    private Node head;
    private Node tail;
    private int count = 0;
    //保存数据
    private HashMap<Integer,Node> map;

    public LRUCache(int capacity){
        if (capacity == 0)
            throw new IllegalArgumentException("capacity can not be 0");
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next =tail;
        tail.pre = head;
    }

    //放入节点
    public void put(int key,int value){
        //先去链表中找到这个节点
        Node node = null;
        if (map.getOrDefault(key,null) != null){
            //说明存在节点了，替换以下就行
            node = map.get(key);
            node.val = value;
            deleteNode(node);
        }else {
            node = new Node(key,value);
            if (count == capacity){
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
            }else {
                count ++;
            }
        }
        insertNode(node);
        map.put(key,node);
    }

    //获取value
    public int get(int key){
        if (map.getOrDefault(key,null) == null)
            return -1;
        if (count == 0)
            return -1;
        //调整顺序就完事了
        Node current = map.get(key);
        deleteNode(current);
        insertNode(current);
        return  current.val;
    }




    private void insertNode(Node node){

        //把这个节点插入到头节点
        Node next = head.next;
        head.next = node;
        node.next = next;
        next.pre = node;
        node.pre = head;

    }
    //从链表中删除
    private void deleteNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = null;
        node.pre = null;
    }





    class Node {
        Node pre;
        Node next;
        int val;
        int key;
        Node(){
        }
        Node(int key,int val) {
            this.val = val;
            this.key = key;
        }
    }




}
