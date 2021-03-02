package problem645;

public final class SetMismatch {

    public int[] findErrorNums(final int[] nums) {
        final boolean[] sortedSet = new boolean[nums.length];
        int dup = -1, miss = -1, idx;
        for (int num : nums) {
            idx = num - 1;
            if (sortedSet[idx]) {
                dup = num;
                continue;
            }
            sortedSet[idx] = true;
        }

        for (int i = 0; i < sortedSet.length; i++) {
            if (!sortedSet[i]) {
                miss = i + 1;
                break;
            }
        }

        return new int[] {dup, miss};
    }

}
