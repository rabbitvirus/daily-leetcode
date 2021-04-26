package problem48;

public final class RotateImage {

    public void rotate(int[][] matrix) {
        final int n = matrix.length;
        if (n == 1)
            return;

        for (int r = 0; r < n / 2; r++) {
            final int rn = n - r - 1;
            for (int p = 0; p < rn - r; p++) {
                final int tmp = matrix[r][r + p];
                matrix[r][r + p] = matrix[rn - p][r];
                matrix[rn - p][r] = matrix[rn][rn - p];
                matrix[rn][rn - p] = matrix[r + p][rn];
                matrix[r + p][rn] = tmp;
            }
        }
    }

}
