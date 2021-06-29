package problem1004;

public final class MaximumConsecutiveOnes {

    public int longestOnes(final int[] nums, final int k) {
        if (nums.length <= k)
            return k;

        int max = 0;
        int toRepl = k;
        int cnt = 0;

        for (int l = 0, r = 0; r < nums.length; ) {
            if (nums[r] == 1) {
                cnt++;
                r++;
            } else if (nums[r] == 0 && toRepl > 0) {
                toRepl--;
                cnt++;
                r++;
            } else {
                max = Math.max(max, cnt);
                while (nums[l] == 1) {
                    l++;
                    cnt--;
                }
                l++;
                r++;
            }
        }

        return Math.max(max, cnt);
    }

}
