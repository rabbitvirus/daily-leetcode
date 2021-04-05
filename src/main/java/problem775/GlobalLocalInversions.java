package problem775;

public final class GlobalLocalInversions {

    public boolean isIdealPermutation(final int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a [i]) {
                if (a[i - 1] != a[i] + 1)
                    return false;
                a[i] = a[i - 1];
            }
        }
        return true;
    }

}
