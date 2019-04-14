package com.ly.linkedlist;

import com.ly.linkedlist.Case141.ListNode;

public class Case203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode mock = new ListNode(0);
        mock.next = head;
        ListNode pre = mock;
        ListNode cur = mock.next;
        while (cur != null) {
            if(cur.val == val) {
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return mock.next;
    }
    
}
