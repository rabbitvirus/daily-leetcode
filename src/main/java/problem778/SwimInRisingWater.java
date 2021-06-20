package problem778;

import java.util.PriorityQueue;

public final class SwimInRisingWater {

    private static final int[][] ADJ = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public int swimInWater(final int[][] grid) {
        final int n = grid.length;
        final boolean[][] visited = new boolean[n][n];

        // int[0] = row, int[1] = col, int[2] = max_val_on_path
        final PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        q.offer(new int[]{0, 0, grid[0][0]});

        while (!q.isEmpty()) {
            final int[] h = q.poll();

            if (h[0] == n - 1 && h[1] == n - 1)
                return Math.max(h[2], grid[n - 1][n - 1]);

            for (final int[] a : ADJ) {
                final int xc = h[0] + a[0];
                final int yc = h[1] + a[1];

                if (0 <= xc && xc < n && 0 <= yc && yc < n && !visited[xc][yc]) {
                    q.offer(new int[]{xc, yc, Math.max(h[2], grid[xc][yc])});
                    visited[xc][yc] = true;
                }
            }
        }

        return -1;
    }

}
