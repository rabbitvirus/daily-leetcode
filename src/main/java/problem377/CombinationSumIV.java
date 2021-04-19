package problem377;

public final class CombinationSumIV {

    public int combinationSum4(final int[] nums, final int target) {
        final int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < target + 1; i++)
            for (int n : nums)
                if (n <= i)
                    dp[i] += dp[i - n];
        return dp[target];
    }

}
