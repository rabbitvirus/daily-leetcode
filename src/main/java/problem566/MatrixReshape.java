package problem566;

public final class MatrixReshape {

    public int[][] matrixReshape(final int[][] mat, final int r, final int c) {
        final int m = mat.length;
        final int n = mat[0].length;

        if (r * c != m * n)
            return mat;

        if (m == r)
            return mat;

        final int[][] reshaped = new int[r][c];
        for (int i = 0, ri = 0, ci = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                reshaped[ri][ci++ % c] = mat[i][j];
                if (ci % c == 0)
                    ri++;
            }
        }

        return reshaped;
    }

}
