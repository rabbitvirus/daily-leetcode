package problem322;

import java.util.Arrays;

public final class CoinChange {

    public int coinChange(final int[] coins, final int amount) {
        if (amount == 0) return 0;

        final int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int tmp;

        for (int i = 1; i < dp.length; i++) {
            for (final int c : coins) {
                if (c > i)
                    continue;

                if (dp[i - c] != Integer.MAX_VALUE) {
                    tmp = 1 + dp[i - c];
                    if (tmp < dp[i])
                        dp[i] = tmp;
                }
            }
        }

        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }

}
