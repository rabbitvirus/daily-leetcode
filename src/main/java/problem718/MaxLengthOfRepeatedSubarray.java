package problem718;

public final class MaxLengthOfRepeatedSubarray {

    public int findLength(final int[] nums1, final int[] nums2) {
        final int n1 = nums1.length;
        final int n2 = nums2.length;

        int[] prev = new int[n1 + 1];
        int max = 0;

        for (int i = n2 - 1; i >= 0; i--) {
            final int[] cur = new int[n1 + 1];
            for (int j = n1 - 1; j >= 0; j--) {
                if (nums1[j] == nums2[i]) {
                    cur[j] = 1 + prev[j + 1];
                    if (cur[j] > max)
                        max = cur[j];
                }
            }
            prev = cur;
        }

        return max;
    }

}
