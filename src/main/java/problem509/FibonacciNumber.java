package problem509;

public final class FibonacciNumber {

    private static final int[] LAZY_CACHE = new int[32];

    static {
        LAZY_CACHE[0] = 0;
        LAZY_CACHE[1] = 1;
    }

    public int fib(final int n) {
        if (n == 0 || LAZY_CACHE[n] != 0)
            return LAZY_CACHE[n];
        LAZY_CACHE[n] = fib(n - 2) + fib(n - 1);
        return LAZY_CACHE[n];
    }

}
