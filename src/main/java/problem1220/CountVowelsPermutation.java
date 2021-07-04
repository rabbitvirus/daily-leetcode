package problem1220;

public final class CountVowelsPermutation {

    // indexes
    private static final int A = 0;
    private static final int E = 1;
    private static final int I = 2;
    private static final int O = 3;
    private static final int U = 4;

    private static final int VOWELS_COUNT = 5;

    private static final int MOD = 1_000_000_007;

    public int countVowelPermutation(final int n) {
        if (n == 1)
            return 5;

        long[] prev = new long[VOWELS_COUNT];
        long[] cur = new long[VOWELS_COUNT];
        long[] tmp;

        for (int i = 0; i < VOWELS_COUNT; i++)
            prev[i] = 1;

        for (int i = 1; i < n; i++) {
            cur[A] = (prev[E] + prev[I] + prev[U]) % MOD;
            cur[E] = (prev[A] + prev[I]) % MOD;
            cur[I] = (prev[E] + prev[O]) % MOD;
            cur[O] = (prev[I]) % MOD;
            cur[U] = (prev[I] + prev[O]) % MOD;

            tmp = prev;
            prev = cur;
            cur = tmp;
        }

        long sum = 0;
        for (int i = 0; i < VOWELS_COUNT; i++)
            sum += prev[i];

        return (int) (sum % MOD);
    }

}
