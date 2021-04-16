package problem1209;

import java.util.LinkedList;

public final class DuplicatesRemover {

    public String removeDuplicates(final String s, final int k) {
        final LinkedList<CountedChar> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (!stack.isEmpty()) {
                final CountedChar l = stack.getLast();
                if (l.c == c) {
                    if (l.cnt == k - 1)
                        stack.removeLast();
                    else
                        l.cnt++;
                } else {
                    stack.add(new CountedChar(c));
                }
            } else {
                stack.add(new CountedChar(c));
            }
        }

        final StringBuilder sb = new StringBuilder(stack.size() * 2);
        for (var c : stack)
            for (int j = 0; j < c.cnt; j++)
                sb.append(c.c);

        return sb.toString();
    }

    private static final class CountedChar {
        private final char c;
        private int cnt = 1;

        CountedChar(final char c) {
            this.c = c;
        }
    }

}
