package problem820;

public class ShortEncodingOfWords {

    public int minimumLengthEncoding(final String[] words) {
        final LowerCaseTrie root = new LowerCaseTrie();
        int len = 0;
        for (final String w : words)
            len += addInReverse(root, w);
        return len;
    }

    private static int addInReverse(final LowerCaseTrie root, final String word) {
        LowerCaseTrie ptr = root;
        int idx;
        int lenDiff = 0;
        boolean longer = false;
        boolean addFull = false;

        for (int i = word.length() - 1; i >= 0; i--) {
            idx = word.charAt(i) - 'a';

            if (ptr.letters[idx] == null) {
                ptr.letters[idx] = new LowerCaseTrie();
                ++lenDiff;
                if (ptr.end) {
                    ptr.end = false;
                    longer = true;
                } else if (!longer) {
                    addFull = true;
                }
            }

            ptr = ptr.letters[idx];

            if (i == 0 && (longer || addFull)) {
                ptr.end = true;
            }
        }

        return lenDiff > 0 ? (addFull ? word.length() + 1 : lenDiff) : lenDiff;
    }


    private static final class LowerCaseTrie {
        private final LowerCaseTrie[] letters = new LowerCaseTrie['z' - 'a' + 1];
        private boolean end;
    }
}
