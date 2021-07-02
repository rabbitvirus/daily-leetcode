package problem658;

import java.util.LinkedList;
import java.util.List;

public final class KClosestElements {

    public List<Integer> findClosestElements(final int[] arr, int k, final int x) {
        final int n = arr.length;
        final LinkedList<Integer> res = new LinkedList<>();

        if (n == k) {
            for (final int e : arr)
                res.add(e);
            return res;
        }

        final int idx = findClosestIdx(arr, x);
        res.add(arr[idx]);

        int l = idx - 1;
        int r = idx + 1;
        while (--k > 0) {
            if (l < 0) {
                res.add(arr[r++]);
            } else if (r >= n) {
                res.addFirst(arr[l--]);
            } else {
                if (Math.abs(x - arr[l]) <= Math.abs(x - arr[r])) {
                    res.addFirst(arr[l--]);
                } else {
                    res.add(arr[r++]);
                }
            }
        }

        return res;
    }

    private static int findClosestIdx(final int[] arr, final int target) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] < target) {
                l = mid + 1;
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }

        if (r < 0)
            return 0;

        if (l > arr.length - 1)
            return arr.length - 1;

        return Math.abs(arr[l] - target) < Math.abs(arr[r] - target) ? l : r;
    }

}
