package problem354;

import java.util.Arrays;
import java.util.Comparator;

public final class RussianDollEnvelopes {

    public int maxEnvelopes(final int[][] envelopes) {
        if (envelopes.length == 1)
            return 1;

        Arrays.sort(envelopes, Comparator.comparingInt((int[] o) -> o[0]).thenComparing(o -> o[1], Comparator.reverseOrder()));
        final int[] lisSeq = new int[envelopes.length];
        int lisLen = 0;

        lisSeq[lisLen] = envelopes[0][1];
        int l, r, mid, cur;

        for (int i = 1; i < envelopes.length; i++) {
            cur = envelopes[i][1];
            r = lisLen;

            if (lisSeq[r] < cur) {
                lisSeq[++lisLen] = cur;
                continue;
            }

            l = 0;
            while (l < r) {
                mid = (l + r) / 2;
                if (lisSeq[mid] < cur) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

            lisSeq[r] = cur;
        }

        return lisLen + 1;
    }

}
