package problem19;

import common.ListNode;

public final class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(final ListNode head, final int n) {
        ListNode slowPtr, fastPtr = head;

        for (int i = 0; i < n; i++)
            fastPtr = fastPtr.next;

        slowPtr = head;
        if (fastPtr == null)
            return head.next;

        while (fastPtr.next != null) {
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }

        slowPtr.next = slowPtr.next.next;
        return head;
    }

}
