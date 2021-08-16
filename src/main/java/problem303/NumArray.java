package problem303;

public final class NumArray {

    private final long[] cumSum;

    public NumArray(final int[] nums) {
        final long[] cumSum = new long[nums.length];
        cumSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            cumSum[i] = cumSum[i - 1] + nums[i];

        this.cumSum = cumSum;
    }

    public int sumRange(final int left, final int right) {
        return (int) (cumSum[right] - (left == 0 ? 0 : cumSum[left - 1]));
    }

}
