package problem795;

public final class BoundedMaxSubarrays {

    public int numSubarrayBoundedMax(final int[] nums, final int left, final int right) {
        if (left > right)
            return 0;

        return countWithMax(nums, right) - countWithMax(nums, left - 1);
    }

    private int countWithMax(final int[] nums, final int max) {
        int res = 0;
        int cnt = 0;
        for (var n : nums) {
            if (n <= max)
                res++;
            else
                res = 0;
            cnt += res;
        }

        return cnt;
    }

}
