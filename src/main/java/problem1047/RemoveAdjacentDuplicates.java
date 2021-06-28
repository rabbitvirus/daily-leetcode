package problem1047;

public final class RemoveAdjacentDuplicates {

    public String removeDuplicates(final String s) {
        final int n = s.length();
        if (n == 1)
            return s;

        final char[] stack = new char[n];
        int ptr = -1;
        for (int i = 0; i < n; i++) {
            final char c = s.charAt(i);
            if (ptr >= 0 && c == stack[ptr]) {
                --ptr;
            } else {
                stack[++ptr] = c;
            }
        }

        return new String(stack, 0, ptr + 1);
    }

}
