package problem1480;

public final class RunningSum {

    public int[] runningSum(final int[] nums) {
        final int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            res[i] = nums[i] + res[i - 1];
        return res;
    }

}
