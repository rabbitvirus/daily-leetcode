package problem1690;

public final class StoneGame7 {

    public int stoneGameVII(final int[] stones) {
        int sum = 0;
        for (var s : stones)
            sum += s;

        final int n = stones.length;
        final int[][] visited = new int[n][n];

        return recDiff(stones, visited, 0, n - 1, sum);
    }

    private int recDiff(final int[] stones, final int[][] visited, final int leftIdx, final int rightIdx, final int avSum) {
        if (leftIdx >= rightIdx)
            return 0;

        if (visited[leftIdx][rightIdx] != 0)
            return visited[leftIdx][rightIdx];

        final int leftVal = avSum - stones[leftIdx];
        final int rightVal = avSum - stones[rightIdx];

        final int opt = Math.max(
                leftVal - recDiff(stones, visited, leftIdx + 1, rightIdx, leftVal),
                rightVal - recDiff(stones, visited, leftIdx, rightIdx - 1, rightVal)
        );

        visited[leftIdx][rightIdx] = opt;
        return opt;
    }

}
