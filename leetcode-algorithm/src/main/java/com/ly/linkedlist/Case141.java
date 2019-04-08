package com.ly.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class Case141 {
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        set.add(head);
        while (head.next != null) {
            ListNode cur = head.next;
            if(set.contains(cur)) {
                return true;
            }
            set.add(cur);
            head = cur;
        }
        return false;
    }
    
    public boolean hasCycleOp(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null) {
            if(fast == null || fast.next == null) {
                return false;
            }else if (fast == slow) {
                return true;
            }else {
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        return false;
    }
    

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
