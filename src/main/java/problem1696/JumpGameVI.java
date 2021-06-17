package problem1696;

import java.util.PriorityQueue;
import java.util.Queue;

public final class JumpGameVI {

    public int maxResult(final int[] nums, final int k) {
        final int n = nums.length;
        if (n == 1)
            return nums[0];

        final Queue<int[]> maxStackQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int max = nums[n - 1];
        maxStackQ.offer(new int[]{max, n - 1});

        for (int i = n - 2; i >= 0; i--) {
            while (maxStackQ.peek()[1] > i + k)
                maxStackQ.poll();

            max = maxStackQ.peek()[0] + nums[i];
            maxStackQ.offer(new int[]{max, i});
        }

        return max;
    }

}
