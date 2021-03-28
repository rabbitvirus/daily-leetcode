package problem417;

import java.util.LinkedList;
import java.util.List;

public final class PacificAtlanticWaterFlow {

    private static final byte PACIFIC = 1;
    private static final byte ATLANTIC = 10;
    private static final byte BOTH = 11;

    public List<List<Integer>> pacificAtlantic(final int[][] heights) {
        final int m = heights.length, n = heights[0].length;

        final byte[][] marks = new byte[m][n];
        final List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < m; i++)
            dfs(i, 0, m, n, 0, PACIFIC, heights, marks, res);

        for (int i = 0; i < n; i++)
            dfs(0, i, m, n, 0, PACIFIC, heights, marks, res);

        for (int i = m - 1; i >= 0; i--)
            dfs(i, n - 1, m, n, 0, ATLANTIC, heights, marks, res);

        for (int i = n - 1; i >= 0; i--)
            dfs(m - 1, i, m, n, 0, ATLANTIC, heights, marks, res);

        return res;
    }

    private void dfs(final int i, final int j, final int m, final int n, final int last, final byte markVal, final int[][] heights,
                     final byte[][] marks, final List<List<Integer>> result) {
        if ((marks[i][j] & markVal) != 0)
            return;

        if (heights[i][j] < last)
            return;

        marks[i][j] += markVal;
        if (marks[i][j] == BOTH)
            result.add(List.of(i, j));

        if (i > 0) dfs(i - 1, j, m, n, heights[i][j], markVal, heights, marks, result);
        if (i + 1 < m) dfs(i + 1, j, m, n, heights[i][j], markVal, heights, marks, result);
        if (j > 0) dfs(i, j - 1, m, n, heights[i][j], markVal, heights, marks, result);
        if (j + 1 < n) dfs(i, j + 1, m, n, heights[i][j], markVal, heights, marks, result);
    }

}
