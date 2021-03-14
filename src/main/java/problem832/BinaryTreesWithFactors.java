package problem832;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class BinaryTreesWithFactors {

    private static final int MOD = 1_000_000_007;

    public int numFactoredBinaryTrees(final int[] arr) {
        Arrays.sort(arr);

        final Map<Integer, Long> dynLookup = new HashMap<>();
        long comb = 0L;
        long psum;
        int div;

        for (final int n : arr) {
            psum = 1;
            for (int i = 0, cur = arr[i]; cur < n; cur = arr[++i]) {
                if (n % cur == 0) {
                    div = n / cur;
                    if (dynLookup.containsKey(div)) {
                        psum += dynLookup.get(cur) * dynLookup.get(div);
                    }
                }
            }
            dynLookup.put(n, psum);
            comb += psum;
            comb %= MOD;
        }

        return (int) comb;
    }

}
