package problem667;

public final class BeautifulArrangementII {

    public int[] constructArray(final int n, int k) {
        final int[] arr = new int[n];
        boolean sub = true;

        arr[0] = n;
        int i = n - 1;
        while (k > 0) {
            arr[n - i] = sub ? arr[n - i - 1] - k : arr[n - i - 1] + k;
            --k;
            --i;
            sub = !sub;
        }

        for (; i > 0; i--) {
            arr[n - i] = i;
        }

        return arr;
    }

}
