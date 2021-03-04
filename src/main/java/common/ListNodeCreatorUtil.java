package common;

import java.util.Objects;

public final class ListNodeCreatorUtil {

    private ListNodeCreatorUtil() {
    }

    public static ListNode createListFrom(final int[] nums) {
        return createListFrom(nums, null);
    }

    public static ListNode createListFrom(final int[] nums, final ListNode listToAppendAtEnd) {
        Objects.requireNonNull(nums, "List of numbers cannot be null");
        ListNode root = null, next = listToAppendAtEnd;
        for (int i = nums.length - 1; i >= 0; i--) {
            next = root != null ? root : next;
            root = new ListNode(nums[i]);
            root.next = next;
        }
        return root;
    }

}
