package problem746;

public final class MinCostClimbingStairs {

    public int minCostClimbingStairs(final int[] cost) {
        final int n = cost.length;
        if (n == 1)
            return cost[0];

        int dp2 = cost[0];
        int dp1 = cost[1];
        int dp;

        for (int i = 2; i < n; i++) {
            dp = cost[i] + Math.min(dp2, dp1);
            dp2 = dp1;
            dp1 = dp;
        }

        return Math.min(dp1, dp2);
    }

}
