package problem363;

import java.util.TreeSet;

public final class MaxSumOfRectangleNoLargerThanK {

    public int maxSumSubmatrix(final int[][] matrix, final int k) {
        final int rows = matrix.length;
        final int cols = matrix[0].length;

        return cols >= rows ? handleColsBased(matrix, k, rows, cols) : handleRowsBased(matrix, k, rows, cols);
    }

    private int handleColsBased(final int[][] matrix, final int k, final int m, final int n) {
        int res = Integer.MIN_VALUE;

        for (int l = 0; l < n; l++) {
            final int[] sumPerRow = new int[m];
            for (int r = l; r < n; r++) {

                for (int i = 0; i < m; i++)
                    sumPerRow[i] += matrix[i][r];

                res = Math.max(res, findBestResult(sumPerRow, k));
                if (res == k)
                    return k;
            }
        }

        return res;
    }

    private int handleRowsBased(final int[][] matrix, final int k, final int m, final int n) {
        int res = Integer.MIN_VALUE;

        for (int l = 0; l < m; l++) {
            final int[] sumPerCol = new int[n];
            for (int r = l; r < m; r++) {

                for (int i = 0; i < n; i++)
                    sumPerCol[i] += matrix[r][i];

                res = Math.max(res, findBestResult(sumPerCol, k));
                if (res == k)
                    return k;
            }
        }

        return res;
    }

    private int findBestResult(final int[] sums, final int k) {
        final TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        int res = Integer.MIN_VALUE;
        int cumSum = 0;

        for (final int s : sums) {
            cumSum += s;
            final Integer ceil = set.ceiling(cumSum - k);
            if (ceil != null)
                res = Math.max(cumSum - ceil, res);

            if (res == k)
                return k;

            set.add(cumSum);
        }

        return res;
    }

}
