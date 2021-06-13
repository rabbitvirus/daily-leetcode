package problem336;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class PalindromePairs {

    public List<List<Integer>> palindromePairs(final String[] words) {
        final Trie root = new Trie();

        for (int i = 0; i < words.length; i++)
            root.addInReverse(words[i], i);

        final List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < words.length; i++) {
            root.addPalindromeIdxToResult(words[i], i, result);
        }

        return result;
    }


    private static final class Trie {
        private final Trie[] children = new Trie['z' - 'a' + 1];
        private List<Integer> pIdxList = new ArrayList<>();
        private int idx = -1;

        public void addInReverse(final String word, final int idx) {
            Trie cur = this;
            for (int i = word.length() - 1; i >= 0; i--) {
                var chIdx = word.charAt(i) - 'a';

                if (cur.children[chIdx] == null)
                    cur.children[chIdx] = new Trie();

                if (isPalindromeInRange(word, 0, i))
                    cur.pIdxList.add(idx);

                cur = cur.children[chIdx];
            }

            cur.pIdxList.add(idx);
            cur.idx = idx;
        }

        public void addPalindromeIdxToResult(final String word, final int pos, final List<List<Integer>> result) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                if (cur.idx != -1 && cur.idx != pos && isPalindromeInRange(word, i, word.length() - 1))
                    result.add(List.of(pos, cur.idx));

                var chIdx = word.charAt(i) - 'a';
                cur = cur.children[chIdx];
                if (cur == null)
                    return;
            }

            for (var p : cur.pIdxList) {
                if (p != pos)
                    result.add(List.of(pos, p));
            }
        }

        private static boolean isPalindromeInRange(final String str, int from, int to) {
            while (from < to)
                if (str.charAt(from++) != str.charAt(to--))
                    return false;
            return true;
        }
    }

}
