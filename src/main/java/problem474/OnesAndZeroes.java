package problem474;

public final class OnesAndZeroes {

    public int findMaxForm(final String[] strs, final int m, final int n) {
        final int[][] dp = new int[m + 1][n + 1];
        for (final String s : strs) {
            int zeros = 0;
            for (int i = 0; i < s.length(); i++)
                if (s.charAt(i) == '0')
                    zeros++;
            final int ones = s.length() - zeros;

            if (zeros > m || ones > n)
                continue;

            for (int i = m; i >= zeros; i--)
                for (int j = n; j >= ones; j--)
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
        }

        return dp[m][n];
    }

}
