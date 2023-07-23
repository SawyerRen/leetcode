package q0;

import models.ListNode;

public class Q83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
