package problem315;

import java.util.*;

public final class SmallerNumbers {

    private static final int MIN = -10_000;
    private static final int MIN_OFFSET = Math.abs(MIN) + 1;
    private static final int MAX = 10_000;

    public List<Integer> countSmaller(final int[] nums) {
        final int n = nums.length;
        final LinkedList<Integer> res = new LinkedList<>();
        final int[] fenwickArr = new int[MAX + MIN_OFFSET + 4];

        for (int i = n - 1; i >= 0; i--) {
            final int pos = MIN_OFFSET + nums[i];
            res.addFirst(ans(fenwickArr, pos - 1));
            add(fenwickArr, pos);
        }

        return res;
    }

    private int ans(final int[] tree, int n) {
        int ans = 0;
        while (n > 0) {
            ans += tree[n];
            n -= lsb(n);
        }
        return ans;
    }

    private void add(final int[] tree, int n) {
        while (n <= tree.length) {
            tree[n]++;
            n += lsb(n);
        }
    }

    private int lsb(final int n) {
        return n & -n;
    }

}
