package problem792;

import java.util.ArrayList;
import java.util.List;

public final class NumberOfMatchingSubsequences {

    public int numMatchingSubseq(final String s, final String[] words) {
        final List<Integer>[] backwardsCharLookup = new ArrayList['z' - 'a' + 1];

        for (int i = s.length() - 1; i >= 0; i--) {
            var c = s.charAt(i);
            if (backwardsCharLookup[c - 'a'] == null)
                backwardsCharLookup[c - 'a'] = new ArrayList<>();
            backwardsCharLookup[c - 'a'].add(i);
        }

        int mSub = 0;
        int lastIdx, sIdx;

        wLoop: for (var w : words) {
            lastIdx = Integer.MAX_VALUE;
            for (int i = w.length() - 1; i >= 0; i--) {
                var idxList = backwardsCharLookup[w.charAt(i) - 'a'];
                if (idxList == null)
                    continue wLoop;

                sIdx = Integer.MAX_VALUE;
                for (var idx : idxList) {
                    if (idx >= lastIdx)
                        continue;

                    sIdx = idx;
                    break;
                }

                if (sIdx == Integer.MAX_VALUE)
                    continue wLoop;

                lastIdx = sIdx;
            }

            mSub++;
        }

        return mSub;
    }

}
