package com.ly.linkedlist;

import com.ly.linkedlist.Case141.ListNode;

public class Case206 {

    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode newHead = head;
        
        while (cur.next != null) {
            ListNode tmpNode = cur.next;
            cur.next = tmpNode.next;
            tmpNode.next = newHead;
            newHead = tmpNode;
        }
        return newHead;
    }
    
}
