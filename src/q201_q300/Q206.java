package q201_q300;

import models.ListNode;

public class Q206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        head.next = null;
        next.next = head;
        return newHead;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode cur = new ListNode();
        while (head != null) {
            cur = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = cur;
        }
        return dummy.next;
    }
}
