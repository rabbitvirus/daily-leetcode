package problem1338;

import java.util.PriorityQueue;
import java.util.Queue;

public final class ReduceArraySize {

    private static final int MAX_NUM_VAL = 100_000;

    public int minSetSize(final int[] arr) {
        final int n = arr.length;
        final int n2 = n / 2;
        if (n == 1)
            return 1;

        int max = 0;
        final int[] cntLookup = new int[MAX_NUM_VAL + 1];
        for (int num : arr) {
            var cnt = ++cntLookup[num];
            if (cnt == n2)
                return 1;
            if (num > max)
                max = num;
        }

        final Queue<Integer> remQ = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 1; i <= max; i++)
            if (cntLookup[i] != 0)
                remQ.offer(cntLookup[i]);

        int moves = 0;
        int lenToGo = n2;
        while (lenToGo > 0) {
            lenToGo -= remQ.poll();
            moves++;
        }

        return moves;
    }

}
