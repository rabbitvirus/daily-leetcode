package problem1710;

import java.util.PriorityQueue;
import java.util.Queue;

public final class MaximumUnits {

    public int maximumUnits(final int[][] boxTypes, final int truckSize) {
        final Queue<int[]> unitQ = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (var b : boxTypes)
            unitQ.offer(b);

        int units = 0;
        int t = 0;
        while (t <= truckSize && !unitQ.isEmpty()) {
            var b = unitQ.poll();
            var c = Math.min(truckSize - t, b[0]);
            t += c;
            units += c * b[1];
        }

        return units;
    }

}
