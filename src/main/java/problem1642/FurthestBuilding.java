package problem1642;

import java.util.PriorityQueue;

public final class FurthestBuilding {


    public int furthestBuilding(final int[] heights, int bricks, int ladders) {
        final int len = heights.length;
        if (len == 1)
            return len;

        final PriorityQueue<Integer> laddersToBricksQ = new PriorityQueue<>();

        for (int i = 0; i < len - 1; i++) {
            final int diff = heights[i + 1] - heights[i];
            if (diff > 0) {
                if (ladders > 0) {
                    --ladders;
                    laddersToBricksQ.offer(diff);
                } else {
                    if (!laddersToBricksQ.isEmpty() && diff > laddersToBricksQ.peek()) {
                        bricks -= laddersToBricksQ.poll();
                        laddersToBricksQ.offer(diff);
                    } else {
                        bricks -= diff;
                    }
                }

                if (bricks < 0)
                    return i;
            }
        }

        return len - 1;
    }


}
