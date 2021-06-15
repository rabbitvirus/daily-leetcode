package problem473;

import java.util.Arrays;

public final class MatchsticksToSquare {

    public boolean makesquare(final int[] matchsticks) {
        int sum = 0;
        for (var m : matchsticks)
            sum += m;

        if (sum % 4 != 0)
            return false;

        Arrays.sort(matchsticks);
        return dfs(matchsticks, new int[4], sum / 4, matchsticks.length - 1);
    }

    private boolean dfs(final int[] sticks, final int[] res, final int target, final int i) {
        if (i < 0) {
            for (var r : res)
                if (r != target)
                    return false;
            return true;
        }

        for (int k = 0; k < res.length; k++) {
            if (sticks[i] + res[k] <= target) {
                res[k] += sticks[i];
                if (dfs(sticks, res, target, i - 1))
                    return true;
                res[k] -= sticks[i];
            }
        }

        return false;
    }

}
