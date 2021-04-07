package problem1704;

public final class AlikeStringHalves {

    private static final char[] UPPER_CASE_VOWELS = new char[]{'A', 'E', 'I', 'O', 'U'};
    private static final int LOWER_TO_UPPER_CASE_OFFSET = 'a' - 'A';

    public boolean halvesAreAlike(final String s) {
        final int[] charLookup = new int['z' - 'a' + 1];
        final char[] cStr = s.toCharArray();

        for (int i = 0; i < cStr.length / 2; i++) {
            var c = cStr[i];
            charLookup[(c > 'Z' ? c - LOWER_TO_UPPER_CASE_OFFSET : c) - 'A']++;
        }

        for (int i = cStr.length / 2; i < cStr.length; i++) {
            var c = cStr[i];
            charLookup[(c > 'Z' ? c - LOWER_TO_UPPER_CASE_OFFSET : c) - 'A']--;
        }

        var cnt = 0;
        for (char upperCaseVowel : UPPER_CASE_VOWELS)
            cnt += charLookup[upperCaseVowel - 'A'];

        return cnt == 0;
    }

}
