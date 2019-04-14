package com.ly.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class Case138 {

    public static Node copyRandomList(Node head) {
        if(head == null) {
            return head;
        }
        //1. 先将 next 节点全部复制，并放入map
        //2. 复制 random 引用
        Map<Node, Node> map = new HashMap<>();
        Node newHead = new Node();
        newHead.val = head.val;
        map.put(head, newHead);
        
        Node itr = head.next;
        Node cur = newHead;
        while (itr != null) {
            Node tmp = new Node();
            tmp.val = itr.val;
            cur.next = tmp;
            map.put(itr, tmp);
            cur = tmp;
            itr = itr.next;
        }
        cur = newHead;
        itr = head;
        while (itr != null) {
            cur.random = map.get(itr.random);
            itr = itr.next;
            cur = cur.next;
        }
        
        return newHead;
    }
    
    
    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
    
    public static void main(String[] args) {
        Node node1 = new Node();
        node1.val = 1;
        Node node2 = new Node();
        node1.random = node2;
        node1.next = node2;
        node2.val = 2;
        node2.random = node2;
        copyRandomList(node1);
    }
}
