package LinkedList.easy;

import LinkedList.ListNode;

/**
 * Problem link: https://leetcode.com/problems/merge-two-sorted-lists/
 * Companies: amazon | apple | linkedin | microsoft
 */
public class MergeSortedList {
    public static void main(String[] args) {
        MergeSortedList mainObj = new MergeSortedList();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode x = mainObj.mergeTwoLists(l1, l2);
        while (x != null) {
            System.out.println(x.val);
            x = x.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(), curr = head;
        findNext(curr, list1, list2);
        return head.next;
    }

    public void findNext(ListNode curr, ListNode l1, ListNode l2) {
        if (l1 == null) {
            curr.next = l2;
        } else if (l2 == null) {
            curr.next = l1;
        } else {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
            findNext(curr, l1, l2);
        }
    }

    //optimal code
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}
