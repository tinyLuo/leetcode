package com.ly.linkedlist;

import com.ly.linkedlist.Case141.ListNode;

public class Case234 {
    
    public static boolean isPalindrome(ListNode head) {
        //思路：1. 找到中间节点， 快慢指针
        //     2. 找中间节点的过程中慢指针经过的链表反转
        //     3. 慢指针的开始和中间节点开始比较
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode midTmp = slow;
        ListNode prefix = slow;
        while (true) {
            ListNode cur = slow.next;
            
            //说明节点总数是奇数个
            if(fast.next.next == null) {
                midTmp = cur;
                break;
            }
            
            if(fast.next.next.next == null) {
                midTmp = cur.next;
                break;
            }
            fast = fast.next.next;
            
            //链表反转
            ListNode curNext = cur.next;
            slow.next = curNext;
            cur.next = prefix;
            prefix = cur;
        }
        
        while (prefix != null && midTmp != null) {
            if(prefix.val != midTmp.val) {
                return false;
            }
            prefix = prefix.next;
            midTmp = midTmp.next;
        }
        return true;
    }
    
    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);
        node.next.next.next.next = new ListNode(0);
        
        
        isPalindrome(node);
    }
    
}
