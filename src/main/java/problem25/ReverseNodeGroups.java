package problem25;

import common.ListNode;

public final class ReverseNodeGroups {

    public ListNode reverseKGroup(final ListNode head, final int k) {
        if (k == 1)
            return head;

        ListNode newRoot = null;
        ListNode grEnd = null;
        ListNode slow = null;
        ListNode fast = head;
        boolean append = false;

        m: while (fast != null) {
            slow = fast;

            for (int i = 0; i < k - 1; i++) {
                if (fast.next == null) {
                    append = true;
                    break m;
                }
                fast = fast.next;
            }

            final ListNode gNext = fast.next;
            final ListNode nGr = reverseGroup(slow, fast);

            if (newRoot == null)
                newRoot = fast;

            if (grEnd != null)
                grEnd.next = fast;
            grEnd = nGr;

            fast = gNext;
        }

        if (grEnd != null && append)
            grEnd.next = slow;

        return newRoot;
    }

    private ListNode reverseGroup(final ListNode head, final ListNode groupEnd) {
        ListNode newEnd = null;
        ListNode prev = null;
        ListNode cur = head;
        boolean oneMore = false;

        while (cur != groupEnd || oneMore) {
            if (newEnd == null)
                newEnd = cur;

            final ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;

            if (oneMore)
                break;

            if (cur == groupEnd)
                oneMore = true;
        }

        return newEnd;
    }

}
