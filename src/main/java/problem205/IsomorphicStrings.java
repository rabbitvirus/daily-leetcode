package problem205;

public final class IsomorphicStrings {

    public boolean isIsomorphic(final String s, final String t) {
        if (s.length() == 1)
            return true;

        final char[] sCh = s.toCharArray();
        final char[] tCh = t.toCharArray();

        final char[] asciiLookup = new char[256];
        final boolean[] asciiMarked = new boolean[256];

        for (int i = 0; i < s.length(); i++) {
            var sc = sCh[i];
            var tc = tCh[i];

            if (asciiLookup[sc] == 0) {
                if (asciiMarked[tc])
                    return false;

                asciiLookup[sc] = tc;
                asciiMarked[tc] = true;
            } else if (asciiLookup[sc] != tc) {
                return false;
            }
        }

        return true;
    }

}
