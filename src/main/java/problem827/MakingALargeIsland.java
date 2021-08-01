package problem827;

public final class MakingALargeIsland {

    public int largestIsland(final int[][] grid) {
        final int n = grid.length;
        final Integer[][] markings = new Integer[n][n];
        final int[] groupToLen = new int[n * n + 1];

        int groupId = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (markings[i][j] != null)
                    continue;

                if (grid[i][j] == 1) {
                    final int gLen = groupMarkingHelper(i, j, groupId, n, grid, markings);
                    groupToLen[groupId++] = gLen;
                } else {
                    handlePotentialLink(i, j, n, grid, markings);
                }
            }
        }

        if (groupId == 1)
            return 1;

        final int[] linkBuf = new int[4];
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (markings[i][j] > 0) {
                    if (groupToLen[markings[i][j]] > maxLen)
                        maxLen = groupToLen[markings[i][j]];
                } else if (markings[i][j] == 0) {
                    final int linkedMaxLen = lenOfLinkedAreas(i, j, n, groupToLen, markings, linkBuf);
                    if (linkedMaxLen > maxLen)
                        maxLen = linkedMaxLen;
                }
            }
        }

        return maxLen;
    }

    private int groupMarkingHelper(final int i, final int j, final int gId, final int n, final int[][] grid, final Integer[][] markings) {
        if (i < 0 || j < 0 || i >= n || j >= n)
            return 0;

        if (grid[i][j] == 0)
            return 0;

        if (markings[i][j] != null)
            return 0;

        markings[i][j] = gId;
        return 1 + groupMarkingHelper(i - 1, j, gId, n, grid, markings)
                + groupMarkingHelper(i + 1, j, gId, n, grid, markings)
                + groupMarkingHelper(i, j - 1, gId, n, grid, markings)
                + groupMarkingHelper(i, j + 1, gId, n, grid, markings);
    }

    private void handlePotentialLink(final int i, final int j, final int n, final int[][] grid, final Integer[][] markings) {
        if (
                (i - 1 >= 0 && grid[i - 1][j] == 1) ||
                        (i + 1 < n && grid[i + 1][j] == 1) ||
                        (j - 1 >= 0 && grid[i][j - 1] == 1) ||
                        (j + 1 < n && grid[i][j + 1] == 1)
        ) {
            markings[i][j] = 0;
        } else {
            markings[i][j] = -1;
        }
    }

    private int lenOfLinkedAreas(final int i, final int j, final int n, final int[] groupToLen, final Integer[][] markings, final int[] linkBuf) {
        int bufPos = 0;

        if (i - 1 >= 0 && markings[i - 1][j] > 0)
            bufPos = addUniqToBuf(markings[i - 1][j], linkBuf, bufPos);

        if (i + 1 < n && markings[i + 1][j] > 0)
            bufPos = addUniqToBuf(markings[i + 1][j], linkBuf, bufPos);

        if (j - 1 >= 0 && markings[i][j - 1] > 0)
            bufPos = addUniqToBuf(markings[i][j - 1], linkBuf, bufPos);

        if (j + 1 < n && markings[i][j + 1] > 0)
            bufPos = addUniqToBuf(markings[i][j + 1], linkBuf, bufPos);

        if (bufPos == 1)
            return groupToLen[linkBuf[0]] + 1;

        int sumLen = 1;
        for (int k = 0; k < bufPos; k++)
            sumLen += groupToLen[linkBuf[k]];

        return sumLen;
    }

    private int addUniqToBuf(final int groupId, final int[] linkBuf, int bufLen) {
        for (int i = 0; i < bufLen; i++)
            if (linkBuf[i] == groupId)
                return bufLen;
        linkBuf[bufLen++] = groupId;
        return bufLen;
    }

}
