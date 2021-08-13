package problem73;

public final class SetMatrixZeroes {

    public void setZeroes(final int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;

        boolean zeroFirstRow = false;
        boolean zeroFirstCol = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0)
                        zeroFirstRow = true;

                    if (j == 0)
                        zeroFirstCol = true;

                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++)
            if (matrix[i][0] == 0)
                for (int j = 0; j < n; j++)
                    matrix[i][j] = 0;

        for (int j = 1; j < n; j++)
            if (matrix[0][j] == 0)
                for (int i = 0; i < m; i++)
                    matrix[i][j] = 0;

        if (zeroFirstCol)
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;

        if (zeroFirstRow)
            for (int j = 0; j < n; j++)
                matrix[0][j] = 0;
    }

}
