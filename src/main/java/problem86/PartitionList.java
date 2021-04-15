package problem86;

import common.ListNode;

public final class PartitionList {

    public ListNode partition(final ListNode head, final int x) {
        final ListNode lStart = new ListNode(-1), rStart = new ListNode(-1);
        ListNode lPart = lStart, rPart = rStart, ptr = head;

        while (ptr != null) {
            if (ptr.val < x) {
                lPart.next = ptr;
                lPart = lPart.next;
            } else {
                rPart.next = ptr;
                rPart = rPart.next;
            }

            ptr = ptr.next;
        }

        lPart.next = rStart.next;
        rPart.next = null;
        return lStart.next;
    }

}
