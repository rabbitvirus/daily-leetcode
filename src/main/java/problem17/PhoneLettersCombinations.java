package problem17;

import java.util.LinkedList;
import java.util.List;

public final class PhoneLettersCombinations {

    private static final char[][] DIGIT_TO_LETTERS_LOOKUP = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(final String digits) {
        final int len = digits.length();
        if (len == 0)
            return List.of();

        final List<String> outList = new LinkedList<>();
        findCombination(digits.toCharArray(), 0, outList, new char[4], 0);
        return outList;
    }

    private void findCombination(final char[] digitsStr, final int dIdx, final List<String> outList, final char[] resBuf, final int bufIdx) {
        final boolean append = dIdx == digitsStr.length - 1;

        for (final char c : DIGIT_TO_LETTERS_LOOKUP[digitsStr[dIdx] - '2']) {
            resBuf[bufIdx] = c;
            if (append)
                outList.add(new String(resBuf, 0, bufIdx + 1));
            else
                findCombination(digitsStr, dIdx + 1, outList, resBuf, bufIdx + 1);
        }
    }

}
