package problem326;

public final class PowerOfThree {

    private static final double THREE_LOG = Math.log10(3d);

    public boolean isPowerOfThree(final int n) {
        if (n == 0d) return false;
        final double log = Math.log10(n) / THREE_LOG;
        return log == Math.floor(log);
    }

}
