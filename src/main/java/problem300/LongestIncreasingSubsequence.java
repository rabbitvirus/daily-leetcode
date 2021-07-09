package problem300;

public final class LongestIncreasingSubsequence {

    public int lengthOfLIS(final int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 1;

        final int[] lisSeq = new int[n];
        lisSeq[0] = nums[0];
        int lisLen = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > lisSeq[lisLen - 1]) {
                lisSeq[lisLen++] = nums[i];
                continue;
            }

            int l = 0;
            int r = lisLen - 1;

            while (l < r) {
                int mid = (l + r) / 2;
                if (lisSeq[mid] >= nums[i]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            lisSeq[l] = nums[i];
        }

        return lisLen;
    }

}
