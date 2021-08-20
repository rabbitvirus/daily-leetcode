package problem36;

public final class ValidSudoku {

    private static final int N = 9;

    public boolean isValidSudoku(final char[][] board) {
        // check each row
        for (int i = 0; i < N; i++) {
            final boolean[] buffer = new boolean[N];
            for (int j = 0; j < N; j++) {
                var ch = board[i][j] - '1';
                if (0 <= ch && ch < 9) {
                    if (buffer[ch])
                        return false;
                    buffer[ch] = true;
                }
            }
        }

        // check each col
        for (int j = 0; j < N; j++) {
            final boolean[] buffer = new boolean[N];
            for (int i = 0; i < N; i++) {
                var ch = board[i][j] - '1';
                if (0 <= ch && ch < 9) {
                    if (buffer[ch])
                        return false;
                    buffer[ch] = true;
                }
            }
        }

        // check each square
        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                final boolean[] buffer = new boolean[N];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        var ch = board[r + i][c + j] - '1';
                        if (0 <= ch && ch < 9) {
                            if (buffer[ch])
                                return false;
                            buffer[ch] = true;
                        }
                    }
                }
            }
        }

        return true;
    }

}
