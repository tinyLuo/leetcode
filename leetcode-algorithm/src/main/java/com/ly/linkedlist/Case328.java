package com.ly.linkedlist;

import com.ly.linkedlist.Case141.ListNode;

public class Case328 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode l1 = head;
        ListNode l2 = head.next;
        while (l2 != null) {
            //偶然节点的next
            ListNode next = l2.next;
            if(next == null) {
                break;
            }
            //偶然节点的next 的 next
            ListNode nn = next.next;
            //最后一个奇数节点的next节点，也就是第一个偶数节点
            ListNode l1Next = l1.next;
            //指向下一个奇数节点
            l1.next = next;
            //最后一个奇数节点指向第一个偶数节点
            next.next = l1Next;
            l2.next = nn;
            
            l2 = nn;
            l1 = l1.next;
        }
        return head;
    }
}
