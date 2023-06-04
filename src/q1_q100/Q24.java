package q1_q100;

import models.ListNode;

public class Q24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode n1 = cur.next, n2 = cur.next.next;
            n1.next = n2.next;
            n2.next = n1;
            cur.next = n2;
            cur = n1;
        }
        return dummy.next;
    }
}
