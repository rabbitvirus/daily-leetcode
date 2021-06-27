package problem135;

public final class Candy {

    public int candy(final int[] ratings) {
        final int n = ratings.length;
        if (n == 1)
            return 1;

        final int[] greedyCandies = new int[n];
        greedyCandies[0] = 1;

        for (int i = 1; i < n; i++)
            greedyCandies[i] = ratings[i] > ratings[i - 1] ? greedyCandies[i - 1] + 1 : 1;

        int minCandies = greedyCandies[n - 1];
        for (int i = n - 1; i >= 1; i--) {
            if (ratings[i - 1] > ratings[i])
                greedyCandies[i - 1] = Math.max(greedyCandies[i - 1], greedyCandies[i] + 1);

            minCandies += greedyCandies[i - 1];
        }

        return minCandies;
    }

}
