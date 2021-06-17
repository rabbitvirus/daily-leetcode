package problem22;

import java.util.LinkedList;
import java.util.List;

public final class GenerateParentheses {

    public List<String> generateParenthesis(final int n) {
        final char[] str = new char[2 * n];
        str[0] = '(';

        final List<String> result = new LinkedList<>();
        backtrack(result, n, str, 1, 0, 1);
        return result;
    }

    private void backtrack(final List<String> result, final int n, final char[] str, final int open, final int close, final int pos) {
        if (pos == 2 * n) {
            result.add(new String(str));
            return;
        }

        if (open < n) {
            str[pos] = '(';
            backtrack(result, n, str, open + 1, close, pos + 1);
        }

        if (close < open) {
            str[pos] = ')';
            backtrack(result, n, str, open, close + 1, pos + 1);
        }
    }

}
