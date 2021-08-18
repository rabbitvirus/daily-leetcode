package problem91;

public final class DecodeWays {

    public int numDecodings(final String s) {
        final int[] dp2 = new int[3];

        char cur = s.charAt(0);
        dp2[0] = 1;
        dp2[1] = cur != '0' ? 1 : 0;
        dp2[2] = dp2[1];
        char prev = cur;

        for (int i = 1; i < s.length(); i++) {
            cur = s.charAt(i);
            dp2[2] = 0;

            if (cur == prev && cur == 0)
                return 0;

            if (cur != '0')
                dp2[2] = dp2[1];

            if (cur == '0' && (prev == '1' || prev == '2')) {
                // 10 or 20
                dp2[2] = dp2[0];
            } else if (prev == '1' || (prev == '2' && cur <= '6')) {
                dp2[2] += dp2[0];
            }

            prev = cur;
            dp2[0] = dp2[1];
            dp2[1] = dp2[2];
        }

        return dp2[2];
    }

}
