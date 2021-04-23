package problem696;

public final class CountBinarySubstrings {

    private static final char ZERO = '0';
    private static final char ONE = '1';

    public int countBinarySubstrings(final String s) {
        final int len = s.length();
        char cur = ZERO;
        int zeros = 0;
        int ones = 0;
        int strings = 0;

        for (int i = 0; i < len; i++) {
            if (cur == s.charAt(i)) {
                if (cur == ZERO)
                    zeros++;
                else
                    ones++;
            } else {
                strings += Math.min(zeros, ones);
                if (cur == ZERO) {
                    ones = 1;
                    cur = ONE;
                } else {
                    zeros = 1;
                    cur = ZERO;
                }
            }
        }

        return strings + Math.min(zeros, ones);
    }

}
