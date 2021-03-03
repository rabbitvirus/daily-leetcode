package problem268;

public final class MissingNumber {

    public int missingNumber(final int[] nums) {
        int res = nums.length * (nums.length + 1) / 2;
        for (final int n : nums)
            res -= n;
        return res;
    }

}
