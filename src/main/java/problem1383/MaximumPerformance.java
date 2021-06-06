package problem1383;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public final class MaximumPerformance {

    private static final int MOD = 1_000_000_007;

    public int maxPerformance(final int n, final int[] speed, final int[] efficiency, final int k) {
        final Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++)
            idx[i] = i;

        Arrays.sort(idx, (a, b) -> efficiency[b] - efficiency[a]);
        final Queue<Integer> speedQ = new PriorityQueue<>();

        long groupSpeed = 0L;
        long bestScore = 0L;

        for (int i = 0; i < k; i++) {
            var sp = speed[idx[i]];
            speedQ.offer(sp);
            groupSpeed += sp;
            bestScore = Math.max(bestScore, groupSpeed * efficiency[idx[i]]);
        }

        for (int i = k; i < n; i++) {
            var sp = speed[idx[i]];
            if (sp > speedQ.peek()) {
                groupSpeed += sp - speedQ.poll();
                speedQ.offer(sp);
                bestScore = Math.max(bestScore, groupSpeed * efficiency[idx[i]]);
            }
        }

        return (int) (bestScore % MOD);
    }

}
