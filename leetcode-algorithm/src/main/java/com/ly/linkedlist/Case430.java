package com.ly.linkedlist;

public class Case430 {

    public static Node flatten(Node head) {
        if(head == null) {
            return null;
        }
        //child -> next
        Node newHead = new Node();
        newHead.val = head.val;
        Node cur = nodeCopy(head.child, newHead);
        if(cur == null) {
            cur = newHead;
        }
        nodeCopy(head.next, cur);
        return newHead;
    }
    
    public static Node nodeCopy(Node itr, Node cur) {
        if(itr == null) {
            return null;
        }
        if(cur == null) {
            System.out.println(itr.val);
        }
        Node newNode = new Node();
        newNode.val = itr.val;
        cur.next = newNode;
        newNode.prev = cur;
        cur = cur.next;
        Node tmp = nodeCopy(itr.child, cur);
        if(tmp != null) {
            cur = tmp;
        }
        tmp = nodeCopy(itr.next, cur);
        if(tmp != null) {
            cur = tmp;
        }
        return cur;
    }
    
//    public Node lastNode(Node cur) {
//        Node lastNode = cur;
//        while (cur.next != null) {
//            cur = cur.next;
//            
//        }
//    }
    
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
            
        }
        public Node(int val) {
            this.val = val;
        }

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }
    
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        
        node1.next = node2;
        node2.prev = node1;
        
        node2.next = node6;
        node6.prev = node2;
        node2.child = node3;
        
//        node3.next = node4;
//        node4.prev = node3;
//        node3.child = node5;
        
        flatten(node2);
    }
}
