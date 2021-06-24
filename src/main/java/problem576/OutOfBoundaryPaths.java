package problem576;

public final class OutOfBoundaryPaths {

    private static int MOD = 1_000_000_007;

    public int findPaths(final int m, final int n, final int maxMove, final int startRow, final int startColumn) {
        if (maxMove == 0)
            return 0;

        final int m2 = m + 2;
        final int n2 = n + 2;

        int[][] dpCur = new int[m2][n2];
        int[][] dpPrev = new int[m2][n2];

        for (int i = 1; i <= m; i++) {
            dpCur[i][1] += 1;
            dpCur[i][n] += 1;
        }

        for (int i = 1; i <= n; i++) {
            dpCur[1][i] += 1;
            dpCur[m][i] += 1;
        }

        int res = dpCur[startRow + 1][startColumn + 1];

        for (int k = 1; k < maxMove; k++) {
            int[][] t = dpPrev;
            dpPrev = dpCur;
            dpCur = t;

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dpCur[i][j] = (int) (((long) dpPrev[i - 1][j] + dpPrev[i + 1][j] + dpPrev[i][j - 1] + dpPrev[i][j + 1]) % MOD);
                }
            }

            res = (int) (((long) res + dpCur[startRow + 1][startColumn + 1]) % MOD);
        }

        return res;
    }

}
