package LinkedList.medium;

import LinkedList.ListNode;

public class SwapNodes {
    public static void main(String[] args) {
        SwapNodes mainObj = new SwapNodes();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode x = mainObj.swapPairs(l1);
        while (x != null) {
            System.out.println(x.val);
            x = x.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }
}
