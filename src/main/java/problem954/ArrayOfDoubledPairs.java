package problem954;

import java.util.Arrays;

public final class ArrayOfDoubledPairs {

    private static final int OFFSET = 100_000;

    public boolean canReorderDoubled(final int[] arr) {
        final int n = arr.length;
        if (n % 2 != 0)
            return false;

        Arrays.sort(arr);
        final int[] lookup = new int[2 * (OFFSET + 1)];

        for (int num : arr)
            lookup[num + OFFSET]++;

        for (int num : arr) {
            final int cur = num + OFFSET;

            if (lookup[cur] == 0)
                continue;

            if (num < 0 && num % 2 != 0)
                return false;

            final int num2 = (num < 0 ? num / 2 : 2 * num) + OFFSET;
            if (num2 >= lookup.length || lookup[num2] == 0)
                return false;

            lookup[cur]--;
            lookup[num2]--;
        }

        return true;
    }

}
