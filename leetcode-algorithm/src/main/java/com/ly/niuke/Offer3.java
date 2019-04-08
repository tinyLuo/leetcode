package com.ly.niuke;

import java.util.ArrayList;

public class Offer3 {

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(listNode == null) {
            return arrayList;
        }
        //链表反转
        ListNode pre = null;
        ListNode cur = listNode;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        
        cur = pre;
        
        while (cur != null) {
            arrayList.add(cur.val);
            cur = cur.next;
        }
        
        return arrayList;
    }
    
    public static void main(String[] args) {
        ListNode node1 = new ListNode(67);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(24);
        ListNode node4 = new ListNode(58);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        printListFromTailToHead(node1);
        
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
