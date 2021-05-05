package problem665;

public final class NonDecreasingArray {

    public boolean checkPossibility(final int[] nums) {
        final int n = nums.length;
        boolean foundBreak = false;
        for (int i = 1; i < n; i++)
            if (nums[i] < nums[i - 1]) {
                if (foundBreak || (i - 2 >= 0 && i + 1 < n && nums[i - 2] > nums[i] && nums[i - 1] > nums[i + 1]))
                    return false;
                foundBreak = true;
            }
        return true;
    }

}
