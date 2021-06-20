package problem778;

import java.util.PriorityQueue;

public final class SwimInRisingWater {

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

            // up
            if (h[0] - 1 >= 0 && !visited[h[0] - 1][h[1]]) {
                q.offer(new int[]{h[0] - 1, h[1], Math.max(h[2], grid[h[0] - 1][h[1]])});
                visited[h[0] - 1][h[1]] = true;
            }

            // down
            if (h[0] + 1 < n && !visited[h[0] + 1][h[1]]) {
                q.offer(new int[]{h[0] + 1, h[1], Math.max(h[2], grid[h[0] + 1][h[1]])});
                visited[h[0] + 1][h[1]] = true;
            }

            // left
            if (h[1] - 1 >= 0 && !visited[h[0]][h[1] - 1]) {
                q.offer(new int[]{h[0], h[1] - 1, Math.max(h[2], grid[h[0]][h[1] - 1])});
                visited[h[0]][h[1] - 1] = true;
            }

            // right
            if (h[1] + 1 < n && !visited[h[0]][h[1] + 1]) {
                q.offer(new int[]{h[0], h[1] + 1, Math.max(h[2], grid[h[0]][h[1] + 1])});
                visited[h[0]][h[1] + 1] = true;
            }
        }

        return -1;
    }

}
