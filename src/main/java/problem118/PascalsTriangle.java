package problem118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PascalsTriangle {

    public List<List<Integer>> generate(final int n) {
        final List<List<Integer>> triangle = new ArrayList<>(n);
        triangle.add(List.of(1));
        Integer[] prev = new Integer[]{1};
        Integer[] cur;

        for (int i = 2; i <= n; i++) {
            cur = new Integer[i];
            for (int j = 0, k = i - 1; j <= k; j++, k--) {
                if (j == 0) {
                    cur[0] = 1;
                    cur[k] = 1;
                    continue;
                }

                final int val = prev[j - 1] + prev[j];
                cur[j] = val;
                cur[k] = val;
            }

            triangle.add(Arrays.asList(cur));
            prev = cur;
        }

        return triangle;
    }

}
