package problem307;

public final class NumArray {

    private final int[] segmentTree;
    private final int n;

    public NumArray(final int[] nums) {
        final int[] st = new int[nums.length * 4];
        fillSegmentTree(nums, st, 0, nums.length - 1, 1);
        this.segmentTree = st;
        this.n = nums.length;
    }

    public void update(final int index, final int val) {
        update(index, val, 0, n - 1, 1);
    }

    public int sumRange(final int left, final int right) {
        return findSum(left, right, 0, n - 1, 1);
    }

    private static int fillSegmentTree(final int[] src, final int[] target, final int lIdx, final int rIdx, final int arrPos) {
        if (lIdx == rIdx) {
            target[arrPos] = src[lIdx];
            return src[lIdx];
        }

        final int mid = (lIdx + rIdx) / 2;
        target[arrPos] = fillSegmentTree(src, target, lIdx, mid, 2 * arrPos)
                + fillSegmentTree(src, target, mid + 1, rIdx, 2 * arrPos + 1);
        return target[arrPos];
    }

    private int findSum(final int lIdx, final int rIdx, final int lPos, final int rPos, final int arrPos) {
        if (lIdx > rIdx)
            return 0;

        if (lIdx == lPos && rIdx == rPos)
            return segmentTree[arrPos];

        final int mid = (lPos + rPos) / 2;
        return findSum(lIdx, Math.min(mid, rIdx), lPos, mid, 2 * arrPos)
                + findSum(Math.max(mid + 1, lIdx), rIdx, mid + 1, rPos, 2 * arrPos + 1);
    }

    private void update(final int tIdx, final int val, final int lPos, final int rPos, final int arrPos) {
        if (lPos == rPos) {
            segmentTree[arrPos] = val;
            return;
        }

        final int mid = (lPos + rPos) / 2;
        if (tIdx <= mid)
            update(tIdx, val, lPos, mid, 2 * arrPos);
        else
            update(tIdx, val, mid + 1, rPos, 2 * arrPos + 1);

        segmentTree[arrPos] = segmentTree[2 * arrPos] + segmentTree[2 * arrPos + 1];
    }

}
