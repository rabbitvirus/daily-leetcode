package problem132;

public final class PalindromePartitioningII {

    public int minCut(final String s) {
        final int n = s.length();
        if (n <= 1)
            return 0;

        final char[] chStr = s.toCharArray();
        final boolean[][] isPalinDp = new boolean[n][n];
        final int[] minCuts = new int[n];

        for (int i = 0; i < n; i++) {
            minCuts[i] = i;

            for (int k = 0; k <= i; k++) {
                if (chStr[k] == chStr[i] && ((i - k < 2) || isPalinDp[k + 1][i - 1])) {
                    isPalinDp[k][i] = true;
                    minCuts[i] = k > 0 ? Math.min(minCuts[i], minCuts[k - 1] + 1) : 0;
                }
            }
        }

        return minCuts[n - 1];
    }

}
