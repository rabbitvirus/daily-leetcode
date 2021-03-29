package problem647;

public final class PalindromicSubstrings {

    public int countSubstrings(final String s) {
        final int len = s.length();
        if (len == 1) return 1;

        int cnt = 0;
        final char[] sChar = s.toCharArray();
        for (int i = 0; i < len; i++) {
            cnt += countPalindromesFromCenter(sChar, len, i, i);
            cnt += countPalindromesFromCenter(sChar, len, i, i + 1);
        }

        return cnt;
    }

    private static int countPalindromesFromCenter(final char[] str, final int size, int lCent, int rCent) {
        int cnt = 0;
        while (lCent >= 0 && rCent < size && str[lCent] == str[rCent]) {
            ++cnt;
            --lCent;
            ++rCent;
        }
        return cnt;
    }

}
