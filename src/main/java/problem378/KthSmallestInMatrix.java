package problem378;

import java.util.PriorityQueue;
import java.util.Queue;

public final class KthSmallestInMatrix {

    public int kthSmallest(final int[][] matrix, final int k) {
        if (k == 1)
            return matrix[0][0];

        final int n = matrix.length;
        if (k == n * n)
            return matrix[n - 1][n - 1];

        final boolean[][] visited = new boolean[n][n];
        final Queue<Cell> minQ = new PriorityQueue<>((a, b) -> matrix[a.x][a.y] - matrix[b.x][b.y]);
        int kMin = Integer.MIN_VALUE;
        int ith = 0;

        minQ.offer(new Cell(0, 0));

        while (true) {
            var c = minQ.poll();
            kMin = matrix[c.x][c.y];
            ith++;

            if (ith == k)
                return kMin;

            if (c.x + 1 < n && !visited[c.x + 1][c.y]) {
                minQ.offer(new Cell(c.x + 1, c.y));
                visited[c.x + 1][c.y] = true;
            }

            if (c.y + 1 < n && !visited[c.x][c.y + 1]) {
                minQ.offer(new Cell(c.x, c.y + 1));
                visited[c.x][c.y + 1] = true;
            }

            if (c.x + 1 < n && c.y + 1 < n && !visited[c.x + 1][c.y + 1]) {
                minQ.offer(new Cell(c.x + 1, c.y + 1));
                visited[c.x + 1][c.y + 1] = true;
            }
        }
    }

    private static final class Cell {
        private final int x;
        private final int y;

        Cell(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }

}
