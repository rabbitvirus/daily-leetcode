package problem92;

import common.ListNode;

public final class ReverseLinkedList {

    public ListNode reverseBetween(final ListNode head, final int left, final int right) {
        ListNode cur = head;
        ListNode prev = null;
        for (int i = 1; i < left; i++) {
            prev = cur;
            cur = cur.next;
        }

        ListNode rev = cur;
        ListNode last = rev;
        cur = cur.next;

        for (int i = left; i < right; i++) {
            ListNode ln = rev;
            rev = cur;
            cur = cur.next;
            rev.next = ln;
        }

        last.next = cur;

        if (prev != null)
            prev.next = rev;

        return prev != null ? head : rev;
    }

}
