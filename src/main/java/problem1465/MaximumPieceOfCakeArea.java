package problem1465;

import java.util.Arrays;

public final class MaximumPieceOfCakeArea {

    private static final int MOD = 1_000_000_007;

    public int maxArea(final int h, final int w, final int[] horizontalCuts, final int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long maxHorizontalSlice = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        long maxVerticalSlice = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);

        for (int i = 1; i < horizontalCuts.length; i++) {
            var diff = horizontalCuts[i] - horizontalCuts[i - 1];
            if (diff > maxHorizontalSlice)
                maxHorizontalSlice = diff;
        }

        for (int i = 1; i < verticalCuts.length; i++) {
            var diff = verticalCuts[i] - verticalCuts[i - 1];
            if (diff > maxVerticalSlice)
                maxVerticalSlice = diff;
        }

        return (int) (maxHorizontalSlice * maxVerticalSlice % MOD);
    }

}
