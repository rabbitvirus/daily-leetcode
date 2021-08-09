package problem1632;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public final class RankTransformMatrix {

    public int[][] matrixRankTransform(final int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;

        final CoordRanked[][] matrixAsNodes = new CoordRanked[m][n];
        final int[][] ranks = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                matrixAsNodes[i][j] = new CoordRanked(i, j, matrix[i][j]);

        final PriorityQueue<CoordRanked> sharedQ = new PriorityQueue<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++)
                sharedQ.offer(matrixAsNodes[r][c]);

            var prev = sharedQ.poll();
            for (int i = 1; i < n; i++)
                prev = handleOrderedCoords(sharedQ, prev);
        }

        for (int c = 0; c < n; c++) {
            for (int r = 0; r < m; r++)
                sharedQ.offer(matrixAsNodes[r][c]);

            var prev = sharedQ.poll();
            for (int i = 1; i < m; i++)
                prev = handleOrderedCoords(sharedQ, prev);
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                var cur = matrixAsNodes[r][c];
                var par = cur.findRoot();
                if (cur != par) {
                    for (var d : cur.deps)
                        par.deps.add(d);
                }
            }
        }

        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
                ranks[r][c] = matrixAsNodes[r][c].findRoot().calcRank();

        return ranks;
    }

    private CoordRanked handleOrderedCoords(final PriorityQueue<CoordRanked> sharedQ, CoordRanked prev) {
        var cur = sharedQ.poll();
        if (cur.matrixVal > prev.matrixVal)
            cur.findRoot().deps.add(prev);
        else
            cur.union(prev);
        prev = cur;
        return prev;
    }

    private static final class CoordRanked implements Comparable<CoordRanked> {

        private final int x;
        private final int y;
        private final int matrixVal;

        private CoordRanked parent;
        private Set<CoordRanked> deps = new HashSet<>();
        private int rank = -1;
        private int balanceCounter = 1;

        public CoordRanked(final int x, final int y, final int matrixVal) {
            this.x = x;
            this.y = y;
            this.matrixVal = matrixVal;
        }

        CoordRanked findRoot() {
            return parent == null ? this : parent.findRoot();
        }

        void union(final CoordRanked second) {
            var firstRoot = findRoot();
            var secondRoot = second.findRoot();

            if (firstRoot == secondRoot) {
                return;
            }

            if (firstRoot.balanceCounter < secondRoot.balanceCounter) {
                firstRoot.parent = secondRoot;
                secondRoot.balanceCounter += firstRoot.balanceCounter;
            } else {
                secondRoot.parent = firstRoot;
                firstRoot.balanceCounter += secondRoot.balanceCounter;
            }
        }

        int calcRank() {
            if (rank == -1) {
                if (!deps.isEmpty()) {
                    int maxDepRank = Integer.MIN_VALUE;
                    for (var d : deps)
                        maxDepRank = Math.max(maxDepRank, d.findRoot().calcRank());
                    rank = maxDepRank + 1;
                } else {
                    rank = 1;
                }
            }
            return rank;
        }

        @Override
        public int compareTo(final CoordRanked o) {
            var valComp = matrixVal - o.matrixVal;
            if (valComp != 0) {
                return valComp;
            }

            // for stable sorting...
            var xComp = x - o.x;
            return xComp != 0 ? xComp : y - o.y;
        }
    }

}
