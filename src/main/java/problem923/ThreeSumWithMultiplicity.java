package problem923;

public final class ThreeSumWithMultiplicity {

    public int threeSumMulti(int[] arr, int target) {
        final int[] lookup = new int[101];
        for (final int n : arr)
            lookup[n]++;

        long cnt = 0L;

        for (int i = 0; i < lookup.length; i++) {
            if (lookup[i] == 0) continue;
            for (int j = i; j < lookup.length; j++) {
                if (lookup[j] == 0) continue;
                final int k = target - i - j;
                if (k < j || k > 100) continue;
                final int x = lookup[i], y = lookup[j], z = lookup[k];

                if (i == j && j == k) {
                    cnt += (long) x * (x - 1) * (x - 2) / 6;
                } else if (i == j) {
                    cnt += (long) z * x * (x - 1) / 2;
                } else if (j == k) {
                    cnt += (long) x * y * (y - 1) / 2;
                } else {
                    cnt += (long) x * y * z;
                }
            }
        }

        return (int) (cnt % 1_000_000_007L);
    }

}
