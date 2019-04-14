package com.ly.linkedlist;

import com.ly.linkedlist.Case141.ListNode;

public class Case61 {
    
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }
        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }
        int vk = k % len;
        if(vk == 0) {
            return head;
        }
        cur = head;
        cur = reverse(cur, null);
        
        ListNode right = cur;
        while (vk > 0) {
            right = right.next;
            vk--;
        }
        ListNode left = cur;
        
        cur = reverse(cur, right);
        right = reverse(right, null);
        left.next = right;
        return cur;
    }
    
    
    //反转链表
    public static ListNode reverse(ListNode cur, ListNode end) {
        ListNode pre = cur;
        while (cur.next != null && cur.next != end) {
            ListNode next = cur.next;
            ListNode nn = next.next;
            next.next = pre;
            cur.next = nn;
            pre = next;
        }
        return pre;
    }
    
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        rotateRight(node1, 2);
    }
}
