package problem37;

public final class SudokuSolver {

    private static final int N_CELL = 3;
    private static final int N = N_CELL * N_CELL;

    private static final char NOT_OCCUPIED_CHAR = '.';

    public void solveSudoku(final char[][] board) {
        backtrackingSolver(board, 0);
    }

    private boolean backtrackingSolver(final char[][] board, final int startRowSearch) {
        final int[] nextEmpty = findNextEmptyCell(board, startRowSearch);
        if (nextEmpty == null)
            return true;

        for (char i = '1'; i <= '9'; i++) {
            if (!canBePut(board, i, nextEmpty[0], nextEmpty[1]))
                continue;

            board[nextEmpty[0]][nextEmpty[1]] = i;
            if (backtrackingSolver(board, nextEmpty[0]))
                return true;
        }

        board[nextEmpty[0]][nextEmpty[1]] = NOT_OCCUPIED_CHAR;
        return false;
    }

    private int[] findNextEmptyCell(final char[][] board, final int startRowSearch) {
        for (int i = startRowSearch; i < N; i++)
            for (int j = 0; j < N; j++)
                if (board[i][j] == NOT_OCCUPIED_CHAR)
                    return new int[]{i, j};
        return null;
    }

    private boolean canBePut(final char[][] board, final char c, final int i, final int j) {
        return canBePutInRow(board, c, i) && canBePutInCol(board, c, j) && canBePutInCell(board, c, i / N_CELL * N_CELL, j / N_CELL * N_CELL);
    }

    private boolean canBePutInCell(final char[][] board, final char c, final int rowStart, final int colStart) {
        for (int i = rowStart; i < rowStart + N_CELL; i++)
            for (int j = colStart; j < colStart + N_CELL; j++)
                if (board[i][j] == c)
                    return false;
        return true;
    }

    private boolean canBePutInCol(final char[][] board, final char c, final int col) {
        for (int i = 0; i < N; i++)
            if (board[i][col] == c)
                return false;
        return true;
    }

    private boolean canBePutInRow(final char[][] board, final char c, final int row) {
        for (int j = 0; j < N; j++)
            if (board[row][j] == c)
                return false;
        return true;
    }

}
