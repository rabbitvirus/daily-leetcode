package problem376;

public final class WiggleSubsequence {

    public int wiggleMaxLength(final int[] nums) {
        final int nLen = nums.length;
        if (nLen == 1) return 1;

        int len = 1;
        int i = 1;
        while (nums[i] == nums[i - 1]) {
            ++i;
            if (i == nLen) return len;
        }

        boolean grow = nums[i] > nums[i - 1];

        for (; i < nLen; i++) {
            if ((grow && nums[i] > nums[i - 1]) || (!grow && nums[i] < nums[i - 1])) {
                grow = !grow;
                ++len;
            }
        }

        return len;
    }

}
