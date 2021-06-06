package problem128;

import java.util.HashSet;
import java.util.Set;

public final class LongestConsecutiveSequence {

    public int longestConsecutive(final int[] nums) {
        final Set<Integer> nSet = new HashSet<>();
        for (var n : nums)
            nSet.add(n);

        int maxLen = 0;

        for (var n : nSet) {
            if (!nSet.contains(n - 1)) {
                int curLen = 1;
                while (nSet.contains(++n))
                    curLen++;

                if (curLen > maxLen)
                    maxLen = curLen;
            }
        }

        return maxLen;
    }

}
