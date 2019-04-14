package com.ly.linkedlist;

public class Case707 {
    
    class Node {
        private int val;
        private Node next;
        private Node pre;
        
        public Node(int val) {
            this(val, null, null);
        }
        
        public Node(int val, Node next) {
            this(val, next, null);
        }
        
        public Node(int val, Node next, Node pre) {
            this.val = val;
            this.next = next;
            this.pre = pre;
        }

        public int getVal() {
            return val;
        }
        public void setVal(int val) {
            this.val = val;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
        public Node getPre() {
            return pre;
        }
        public void setPre(Node pre) {
            this.pre = pre;
        }
    }
    
    private Node head;
    
    private Node tail;
    
    public Case707() {
        
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is
     * invalid, return -1.
     */
    public int get(int index) {
        if(index < 0) {
            return -1;
        }
        Node searchNode = head;
        while (index > 0) {
            searchNode = head.next;
            index--;
        }
        return searchNode.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After
     * the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        head = new Node(val, head);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        tail = new Node(val, null, tail);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index
     * equals to the length of linked list, the node will be appended to the end of
     * linked list. If index is greater than the length, the node will not be
     * inserted.
     */
    public void addAtIndex(int index, int val) {
        if(index < 0) {
            return ;
        }
        Node searchNode = head;
        while (index > 0) {
            searchNode = head.next;
            index--;
        }
        Node pre = searchNode.pre;
        Node cur = new Node(val, searchNode, pre);
        searchNode.pre = cur;
        pre.next = cur;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0) {
            return ;
        }
        Node searchNode = head;
        while (index > 0) {
            searchNode = head.next;
            index--;
        }
        Node pre = searchNode.pre;
        Node next = searchNode.next;
        pre.next = next;
        next.pre = pre;
    }
    
}
