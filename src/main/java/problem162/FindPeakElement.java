package problem162;

public final class FindPeakElement {

    public int findPeakElement(final int[] nums) {
        final int n = nums.length;
        if (n == 1)
            return 0;

        if (nums[0] > nums[1])
            return 0;
        else if (nums[n - 2] < nums[n - 1])
            return n - 1;

        int l = 1;
        int r = n - 2;

        // tricky...
        while (l < r) {
            int mid = (l + r) / 2;

            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1])
                return mid;

            if (nums[mid] < nums[mid + 1])
                l = mid + 1;
            else
                r = mid - 1;
        }

        return l;
    }

}
