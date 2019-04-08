package com.ly.linkedlist;

import com.ly.linkedlist.Case141.ListNode;

public class Case142 {
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // 第一次相遇
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        
        //head.next = node1;
        //node1.next = node2;
        //node2.next = node3;
        //node3.next = node1;
        detectCycle(head);
    }
}
