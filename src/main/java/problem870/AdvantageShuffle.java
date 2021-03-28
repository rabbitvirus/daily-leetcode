package problem870;

import java.util.Arrays;

public final class AdvantageShuffle {

    public int[] advantageCount(int[] a, int[] b) {
        if (a.length == 1) return a;

        final int[] res = new int[a.length];
        Arrays.fill(res, -1);
        final PosEl[] helperArr = new PosEl[a.length];

        for (int i = 0; i < b.length; i++)
            helperArr[i] = new PosEl(b[i], i);

        Arrays.sort(a);
        Arrays.sort(helperArr);

        int idxA = 0, idxB = 0;

        while (idxA < a.length) {
            final PosEl p = helperArr[idxB];
            if (a[idxA] > p.val) {
                res[p.pos] = a[idxA];
                a[idxA] = -1;
                ++idxB;
            }
            ++idxA;
        }

        idxA = 0;
        int idxR = 0;
        while (idxA < a.length && idxR < res.length) {
            if (a[idxA] == -1) {
                ++idxA;
            } else if (res[idxR] != -1) {
                ++idxR;
            } else {
                res[idxR++] = a[idxA++];
            }
        }

        return res;
    }

    private static final class PosEl implements Comparable<PosEl> {
        private final int val;
        private final int pos;

        PosEl(final int val, final int pos) {
            this.val = val;
            this.pos = pos;
        }

        @Override
        public int compareTo(final PosEl o) {
            return Integer.compare(val, o.val);
        }
    }

}
