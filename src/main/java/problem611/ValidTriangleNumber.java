package problem611;

import java.util.Arrays;

public final class ValidTriangleNumber {

    public int triangleNumber(final int[] nums) {
        Arrays.sort(nums);

        int cnt = 0;

        for (int i = nums.length - 2; i >= 0; i--) {
            int l = 0;
            int r = i;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i + 1]) {
                    cnt += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }

        return cnt;
    }

}
