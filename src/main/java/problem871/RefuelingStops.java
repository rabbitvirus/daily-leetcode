package problem871;

import java.util.PriorityQueue;

public final class RefuelingStops {

    public int minRefuelStops(final int target, final int startFuel, final int[][] stations) {
        if (target > startFuel && stations.length == 0)
            return -1;

        if (startFuel >= target)
            return 0;

        final PriorityQueue<Integer> fuelQ = new PriorityQueue<>((a, b) -> b - a);
        int curMaxDist = startFuel;
        int idx = 0;
        int stops = 0;

        for (;;) {
            if (curMaxDist >= target)
                return stops;

            for (int i = idx; idx < stations.length; i++, idx++) {
                if (curMaxDist < stations[i][0])
                    break;

                fuelQ.offer(stations[i][1]);
            }

            if (fuelQ.isEmpty())
                return -1;

            curMaxDist += fuelQ.poll();
            stops++;
        }
    }

}
