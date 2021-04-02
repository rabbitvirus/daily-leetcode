package problem234;

import common.ListNode;

import java.util.Arrays;

public final class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        int size = 32;
        int[] arr = new int[size];
        int n = 0;

        while (head != null) {
            if (n >= size) {
                size *= 2;
                arr = Arrays.copyOf(arr, size);
            }
            arr[n++] = head.val;
            head = head.next;
        }

        int i = 0, j = n - 1;
        while (i < j) {
            if (arr[i] != arr[j])
                return false;
            i++;
            j--;
        }

        return true;
    }

}
