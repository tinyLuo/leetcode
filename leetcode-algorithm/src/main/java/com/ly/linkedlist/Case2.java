package com.ly.linkedlist;

import com.ly.linkedlist.Case141.ListNode;

public class Case2 {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode mock = new ListNode(0);
        ListNode cur = mock;
        int jy = 0;
        while (l1 != null | l2 != null) {
            if(l1 == null) {
                int v = l2.val + jy;
                if(v == 10) {
                    jy = 1;
                    v = 0;
                }else {
                    jy = 0;
                }
                cur.next = new ListNode(v);
                cur = cur.next;
                l2 = l2.next;
            } else if (l2 == null) {
                int v = l1.val + jy;
                if(v == 10) {
                    jy = 1;
                    v = 0;
                }else {
                    jy = 0;
                }
                cur.next = new ListNode(v);
                cur = cur.next;
                l1 = l1.next;
            } else {
                int v = l1.val + l2.val + jy;
                if(v > 9) {
                    v -= 10;
                    jy = 1;
                }else {
                    jy = 0;
                }
                cur.next = new ListNode(v);
                cur = cur.next;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        if(jy == 1) {
            cur.next = new ListNode(1);
        }
        return mock.next;
    }
    
}
