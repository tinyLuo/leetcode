package com.ly.linkedlist;

import com.ly.linkedlist.Case141.ListNode;

public class Case160 {
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode anext = headA;
        ListNode bnext = headB;
        while (anext != bnext) {
            anext = anext == null ? headB : anext.next;
            bnext = bnext == null ? headA : bnext.next;
        }
        return anext;
    }
}
