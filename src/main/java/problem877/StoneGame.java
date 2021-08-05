package problem877;

public final class StoneGame {

    public boolean stoneGame(final int[] piles) {
        final int n = piles.length;

        int bestMinSum = 0;
        int bestMaxSum = 0;

        int l = 0;
        int r = n - 1;

        while (l < r) {
            if (piles[l] >= piles[r])
                bestMaxSum += piles[l++];
            else
                bestMaxSum += piles[r--];

            if (piles[l] <= piles[r])
                bestMinSum += piles[l++];
            else
                bestMinSum += piles[r--];
        }

        return bestMinSum < bestMaxSum;
    }

}
