package com.ly.linkedlist;

import com.ly.linkedlist.Case141.ListNode;

public class Case21 {
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mock = new ListNode(0);
        ListNode cur = mock;
        while (l1 != null || l2 != null) {
            if(l1 == null) {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
                continue;
            }
            if(l2 == null) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
                continue;
            }
            if(l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return mock.next;
    }
    
    public static void main(String[] args) {
        ListNode node = new ListNode(-9);
        node.next = new ListNode(3);
        //node.next.next = new ListNode(4);
        
        ListNode node1 = new ListNode(5);
        node1.next = new ListNode(7);
        //node1.next.next = new ListNode(4);
        
        mergeTwoLists(node, node1);
    }
    
}
