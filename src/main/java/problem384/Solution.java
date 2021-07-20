package problem384;

import java.util.Arrays;

public class Solution {

    private final int[] original;
    private final int len;

    public Solution(final int[] nums) {
        this.original = Arrays.copyOf(nums, nums.length);
        this.len = nums.length;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return Arrays.copyOf(original, len);
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        final int[] cpy = Arrays.copyOf(original, len);
        for (int i = 0; i < len; i++) {
            final int rIdx = (int) Math.floor(Math.random() * (i + 1));
            if (rIdx != i) {
                cpy[i] ^= cpy[rIdx];
                cpy[rIdx] ^= cpy[i];
                cpy[i] ^= cpy[rIdx];
            }
        }
        return cpy;
    }

}
