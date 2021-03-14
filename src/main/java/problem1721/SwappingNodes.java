package problem1721;

import common.ListNode;

public final class SwappingNodes {

    public ListNode swapNodes(final ListNode head, final int k) {
        int cnt = 0;
        ListNode ptr = head;

        while (cnt < k - 1) {
            ptr = ptr.next;
            cnt++;
        }

        final ListNode l1 = ptr;
        while (ptr != null) {
            ptr = ptr.next;
            cnt++;
        }

        ptr = head;
        for (int i = 0; i < cnt - k; i++)
            ptr = ptr.next;

        final ListNode l2 = ptr;

        if (l1 == l2)
            return head;

        l1.val = l1.val ^ l2.val;
        l2.val = l2.val ^ l1.val;
        l1.val = l1.val ^ l2.val;

        return head;
    }

}
