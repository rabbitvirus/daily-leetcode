package problem63;

public final class UniquePathsII {

    public int uniquePathsWithObstacles(final int[][] obstacleGrid) {
        final int m = obstacleGrid.length;
        final int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
            return 0;

        final Integer[][] visitedNodesGrid = new Integer[m][n];
        visitedNodesGrid[m - 1][n - 1] = 1;

        return dfs(obstacleGrid, visitedNodesGrid, 0, 0, m, n);
    }

    private int dfs(final int[][] obstacleGrid, final Integer[][] vGrid, final int i, final int j, final int m, final int n) {
        if (vGrid[i][j] != null)
            return vGrid[i][j];

        final int i1 = i + 1;
        final int j1 = j + 1;

        int paths = 0;
        if (i1 < m)
            if (obstacleGrid[i1][j] != 1)
                paths += dfs(obstacleGrid, vGrid, i1, j, m, n);

        if (j1 < n)
            if (obstacleGrid[i][j1] != 1)
                paths += dfs(obstacleGrid, vGrid, i, j1, m, n);

        vGrid[i][j] = paths;
        return paths;
    }

}
