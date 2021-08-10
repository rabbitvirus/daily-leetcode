package problem926;

public final class FlipStringToMonotoneIncreasing {

    public int minFlipsMonoIncr(final String s) {
        final int n = s.length();
        if (n <= 1)
            return 0;

        final char[] sCh = s.toCharArray();
        int ones = 0;
        int flips = 0;

        for (var ch : sCh) {
            if (ch == '0')
                flips = Math.min(flips + 1, ones);
            else
                ++ones;
        }

        return flips;
    }

}
