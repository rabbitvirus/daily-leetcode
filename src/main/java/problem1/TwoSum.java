package problem1;

import java.util.HashMap;
import java.util.Map;

public final class TwoSum {

    public int[] twoSum(final int[] nums, final int target) {
        final int n = nums.length;
        final Map<Integer, Integer> numToIdxLookup = new HashMap<>();

        for (int i = 0; i < n; i++) {
            var prev = numToIdxLookup.get(target - nums[i]);
            if (prev != null)
                return new int[] {prev, i};

            numToIdxLookup.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

}
