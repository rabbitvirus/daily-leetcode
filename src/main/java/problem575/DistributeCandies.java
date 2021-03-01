package problem575;

public final class DistributeCandies {

    private static final int NON_NEG_OFFSET = 100_000;
    private static final int RANGE = 2 * NON_NEG_OFFSET + 1;

    public int distributeCandies(final int[] candyType) {
        final int n2 = candyType.length / 2;
        final boolean[] setLookup = new boolean[RANGE];
        int setCnt = 0, idx;

        for (final int ct : candyType) {
            idx = ct + NON_NEG_OFFSET;
            if (!setLookup[idx]) {
                setLookup[idx] = true;
                if (++setCnt == n2) break;
            }
        }
        return Math.min(setCnt, n2);
    }

}
