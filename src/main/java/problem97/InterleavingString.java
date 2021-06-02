package problem97;

public final class InterleavingString {

    public boolean isInterleave(final String s1, final String s2, final String s3) {
        final int len1 = s1.length();
        final int len2 = s2.length();
        final int len3 = s3.length();

        if (len1 == 0 && len2 == 0 && len3 == 0)
            return true;

        if (len1 + len2 != len3)
            return false;

        final boolean[][] visited = new boolean[len1 + 1][len2 + 1];
        return dfs(s1, s2, s3, 0, 0, 0, visited);
    }

    private boolean dfs(final String str1, final String str2, final String str3, final int idx1, final int idx2, final int idx3,
                        final boolean[][] visited) {
        if (idx3 == str3.length())
            return true;

        if (visited[idx1][idx2])
            return false;

        final boolean ok = (idx1 < str1.length() && str1.charAt(idx1) == str3.charAt(idx3) && dfs(str1, str2, str3, idx1 + 1, idx2, idx3 + 1, visited)) ||
                (idx2 < str2.length() && str2.charAt(idx2) == str3.charAt(idx3) && dfs(str1, str2, str3, idx1, idx2 + 1, idx3 + 1, visited));

        if (!ok)
            visited[idx1][idx2] = true;

        return ok;
    }

}
