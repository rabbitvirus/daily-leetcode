package problem791;

public final class CustomSortString {

    public String customSortString(final String order, final String str) {
        final int[] chCnt = new int['z' - 'a' + 1];

        final char[] strArr = str.toCharArray();
        for (var c : strArr)
            chCnt[c - 'a']++;

        final char[] res = new char[str.length()];
        int pos = 0;
        for (int i = 0; i < order.length(); i++) {
            var oc = order.charAt(i);
            for (int c = chCnt[oc - 'a']; c > 0; c--)
                res[pos++] = oc;
            chCnt[oc - 'a'] = -1;
        }

        for (var c : strArr) {
            if (chCnt[c - 'a'] > 0)
                res[pos++] = c;
        }

        return new String(res);
    }

}
