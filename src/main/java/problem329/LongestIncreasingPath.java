package problem329;

public final class LongestIncreasingPath {

    public int longestIncreasingPath(final int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;

        if (m == 1 && n == 1)
            return 1;

        final Integer[][] visitLenLookup = new Integer[m][n];

        int max = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                max = Math.max(max, visitLenLookup[i][j] != null ? visitLenLookup[i][j] : dfs(matrix, visitLenLookup, m, n, i, j));

        return max;
    }

    private int dfs(final int[][] matrix, final Integer[][] lookup, final int m, final int n, final int i, final int j) {
        final int val = matrix[i][j];
        int max = 1;

        if (i - 1 >= 0 && val < matrix[i - 1][j])
            max = Math.max(max, (lookup[i - 1][j] != null ? lookup[i - 1][j] : dfs(matrix, lookup, m, n, i - 1, j)) + 1);

        if (i + 1 < m && val < matrix[i + 1][j])
            max = Math.max(max, (lookup[i + 1][j] != null ? lookup[i + 1][j] : dfs(matrix, lookup, m, n, i + 1, j)) + 1);

        if (j - 1 >= 0 && val < matrix[i][j - 1])
            max = Math.max(max, (lookup[i][j - 1] != null ? lookup[i][j - 1] : dfs(matrix, lookup, m, n, i, j - 1)) + 1);

        if (j + 1 < n && val < matrix[i][j + 1])
            max = Math.max(max, (lookup[i][j + 1] != null ? lookup[i][j + 1] : dfs(matrix, lookup, m, n, i, j + 1)) + 1);

        lookup[i][j] = max;
        return max;
    }

}
