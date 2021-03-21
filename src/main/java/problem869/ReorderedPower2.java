package problem869;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class ReorderedPower2 {

    private static final Set<Long> DIGITS_AS_NUMS_LOOKUP;

    static {
        final Set<Long> lookup = new HashSet<>();
        int n = 1;
        while (n < 1_000_000_000) {
            lookup.add(countDigitsToNum(n));
            n *= 2;
        }
        DIGITS_AS_NUMS_LOOKUP = Collections.unmodifiableSet(lookup);
    }

    private static long countDigitsToNum(int n) {
        final int[] arr = new int[10];
        while (n > 0) {
            arr[n % 10]++;
            n /= 10;
        }

        long num = 0;
        for (final int value : arr) {
            num *= 10;
            num += value;
        }
        return num;
    }

    public boolean reorderedPowerOf2(final int n) {
        return DIGITS_AS_NUMS_LOOKUP.contains(countDigitsToNum(n));
    }

}
