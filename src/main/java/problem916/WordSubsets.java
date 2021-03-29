package problem916;

import java.util.LinkedList;
import java.util.List;

public final class WordSubsets {

    private static final int CHARS_CNT = 'z' - 'a' + 1;

    public List<String> wordSubsets(final String[] a, final String[] b) {
        final List<String> res = new LinkedList<>();

        final short[] bAggr = toAggregatedDensArray(b);
        wLoop: for (final String w : a) {
            final short[] wAggr = toDensArray(w);
            for (int i = 0; i < CHARS_CNT; i++)
                if (bAggr[i] > 0 && bAggr[i] > wAggr[i])
                    continue wLoop;
            res.add(w);
        }

        return res;
    }

    private static short[] toDensArray(final String word) {
        final short[] arr = new short[CHARS_CNT];
        for (final char c : word.toCharArray())
            arr[c - 'a']++;
        return arr;
    }

    private static short[] toAggregatedDensArray(final String[] words) {
        final short[] res = new short[CHARS_CNT];

        for (final String w : words) {
            final short[] buf = new short[CHARS_CNT];
            for (final char c : w.toCharArray())
                buf[c - 'a']++;

            for (int i = 0; i < buf.length; i++)
                if (buf[i] > res[i])
                    res[i] = buf[i];
        }

        return res;
    }

}
