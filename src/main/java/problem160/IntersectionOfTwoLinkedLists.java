package problem160;

import common.ListNode;

public final class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(final ListNode headA, final ListNode headB) {
        if (headA == null || headB == null) return null;

        final int lenA = listLen(headA);
        final int lenB = listLen(headB);
        int lenDiff;
        ListNode shorter, longer;

        if (lenA <= lenB) {
            lenDiff = lenB - lenA;
            shorter = headA;
            longer = headB;
        } else {
            lenDiff = lenA - lenB;
            shorter = headB;
            longer = headA;
        }

        for (int i = 0; i < lenDiff; i++) longer = longer.next;

        while (shorter != null) {
            if (shorter == longer) return shorter;
            shorter = shorter.next;
            longer = longer.next;
        }

        return null;
    }

    private int listLen(ListNode l) {
        int len = 0;
        while (l != null) {
            ++len;
            l = l.next;
        }
        return len;
    }
}
