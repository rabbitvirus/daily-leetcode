package problem462;

import java.util.Arrays;

public final class MinimumMoves2 {

    public int minMoves2(final int[] nums) {
        Arrays.sort(nums);

        int l = 0, r = nums.length - 1;
        int steps = 0;

        while (l <= r)
            steps += nums[r--] - nums[l++];

        return steps;
    }
}
