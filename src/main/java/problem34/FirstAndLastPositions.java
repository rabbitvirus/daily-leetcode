package problem34;

import java.util.Arrays;

public final class FirstAndLastPositions {

    public int[] searchRange(final int[] nums, final int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};

        int l = 0, r = nums.length - 1;
        int mid = (l + r) / 2;
        while (l <= r) {
            if (nums[mid] < target) {
                l = mid + 1;
                mid = (l + r) / 2;
            } else if (nums[mid] > target) {
                r = mid - 1;
                mid = (l + r) / 2;
            } else {
                l = mid;
                r = mid;
                while (l - 1 >= 0 && nums[l - 1] == target)
                    l--;

                while (r + 1 < nums.length && nums[r + 1] == target)
                    r++;

                return new int[]{l, r};
            }
        }

        return new int[]{-1, -1};
    }

}
