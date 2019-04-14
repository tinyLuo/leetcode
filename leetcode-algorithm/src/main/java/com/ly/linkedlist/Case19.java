package com.ly.linkedlist;

import com.ly.linkedlist.Case141.ListNode;

public class Case19 {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for(int i = 0 ; i < n+1 ; i++) {
            first = first.next;
        }
        
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
        
    }
    
}
