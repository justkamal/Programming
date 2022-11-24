package LinkedList.medium;

import LinkedList.ListNode;

/**
 * Problem: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * */

public class RemoveNthNodeFromEnd {

    private static int calculateSize(ListNode l1) {
        int countNodes = 0;
        while (l1 != null) {
            ++countNodes;
            l1 = l1.next;
        }
        return countNodes;
    }

    public ListNode removeNthFromEnd(ListNode l1, int n) {
        int size = calculateSize(l1);
        n = size - n;
        ListNode curr = l1;
        if (n == 0) {
            l1 = l1.next;
        } else {
            while (--n > 0) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
        return l1;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEnd mainObj = new RemoveNthNodeFromEnd();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(2, new ListNode(4));
        System.out.println(mainObj.removeNthFromEnd(l2, 2));
    }
}
