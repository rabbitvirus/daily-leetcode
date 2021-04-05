package problem32;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class LongestValidParentheses {

    public int longestValidParentheses(final String s) {
        final int len = s.length();
        if (len == 0)
            return 0;

        final LinkedList<Integer> stack = new LinkedList<>();
        final Map<Integer, Integer> closePosToLen = new HashMap<>();
        int maxLen = 0;

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                stack.add(i);
            } else {
                if (stack.isEmpty())
                    continue;
                final int st = stack.removeLast();
                final int ss = i - st + 1;
                final int c = closePosToLen.getOrDefault(st - 1, 0);
                final int cs = c + ss;
                maxLen = Math.max(maxLen, cs);
                closePosToLen.put(i, cs);
            }
        }

        return maxLen;
    }

}
