package q201_q300;

import models.ListNode;

public class Q234 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head, preMid = head;
        while (fast != null && fast.next != null) {
            preMid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        preMid.next = null;
        ListNode reverseHead = reverse(slow);
        while (head != null && reverseHead != null) {
            if (head.val != reverseHead.val) return false;
            head = head.next;
            reverseHead = reverseHead.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode();
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }
}
