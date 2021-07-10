package problem639;

public final class DecodeWays2 {

    private static final int MOD = 1_000_000_007;

    public int numDecodings(final String s) {
        final long[] dp2 = new long[3];

        char cur = s.charAt(0);
        dp2[0] = 1;
        dp2[1] = cur == '*' ? 9 : (cur != '0' ? 1 : 0);
        dp2[2] = dp2[1];
        char prev = cur;

        for (int i = 1; i < s.length(); i++) {
            cur = s.charAt(i);
            dp2[2] = 0;

            // invalid case check
            if (cur == prev && cur == 0)
                return 0;

            // first, single character case (cur only)
            if (cur != '0') {
                dp2[2] = (dp2[1] * (cur == '*' ? 9 : 1)) % MOD;
            }

            // now, two characters seq
            if (cur == '0') {
                if (prev == '1' || prev == '2') {
                    // 10 or 20
                    dp2[2] = dp2[0];
                } else if (prev == '*') {
                    // *0
                    dp2[2] = (dp2[2] + dp2[0] * 2) % MOD;
                }
            } else if (prev != '0') {
                if (cur == '*' && prev == '*') {
                    // **
                    dp2[2] = (dp2[2] + dp2[0] * 15) % MOD;
                } else if (cur == '*') {
                    // N*
                    if (prev <= '2')
                        dp2[2] = (dp2[2] + dp2[0] * (prev == '1' ? 9 : 6)) % MOD;
                } else if (prev == '*') {
                    // *N
                    dp2[2] = (dp2[2] + dp2[0] * (cur <= '6' ? 2 : 1)) % MOD;
                } else {
                    // NN
                    if (prev == '1' || (prev == '2' && cur <= '6'))
                        dp2[2] = (dp2[2] + dp2[0]) % MOD;
                }
            }

            prev = cur;
            dp2[0] = dp2[1];
            dp2[1] = dp2[2];
        }

        return (int) dp2[2];
    }

}
