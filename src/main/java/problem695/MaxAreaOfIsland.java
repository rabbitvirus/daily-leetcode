package problem695;

public final class MaxAreaOfIsland {

    public int maxAreaOfIsland(final int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;

        final boolean[][] visited = new boolean[m][n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    final int area = dfs(grid, visited, i, j, m, n);
                    if (area > maxArea)
                        maxArea = area;
                }
            }
        }

        return maxArea;
    }

    private int dfs(final int[][] grid, final boolean[][] visited, final int i, final int j, final int m, final int n) {
        if (visited[i][j])
            return 0;

        visited[i][j] = true;

        if (grid[i][j] == 0)
            return 0;

        int area = 1;

        if (i - 1 >= 0)
            area += dfs(grid, visited, i - 1, j, m, n);

        if (i + 1 < m)
            area += dfs(grid, visited, i + 1, j, m, n);

        if (j - 1 >= 0)
            area += dfs(grid, visited, i, j - 1, m, n);

        if (j + 1 < n)
            area += dfs(grid, visited, i, j + 1, m, n);

        return area;
    }

}
