package common;

import java.util.Objects;

/**
 * Ugly class from LeetCode
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(final int x) {
        val = x;
        next = null;
    }

    public ListNode(final int x, final ListNode next) {
        val = x;
        this.next = next;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
