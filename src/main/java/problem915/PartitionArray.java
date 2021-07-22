package problem915;

public final class PartitionArray {

    public int partitionDisjoint(final int[] nums) {
        final int n = nums.length;
        final int[] rightMins = new int[n];

        int leftMax = nums[0];
        int rightMin = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 1; i--) {
            if (rightMin > nums[i])
                rightMin = nums[i];

            rightMins[i] = rightMin;
        }

        for (int i = 1; i < n - 1; i++) {
            if (leftMax <= rightMins[i])
                return i;

            if (leftMax < nums[i])
                leftMax = nums[i];
        }

        return n - 1;
    }

}
