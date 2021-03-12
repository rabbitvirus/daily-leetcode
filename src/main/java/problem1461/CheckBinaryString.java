package problem1461;

public final class CheckBinaryString {

    public boolean hasAllCodes(final String s, final int k) {
        if (s.length() < k) return false;

        final char[] chStr = s.toCharArray();

        int toFind = 1 << k;
        final boolean[] found = new boolean[toFind];
        int tmp;

        for (int i = 0; i < chStr.length - k + 1; i++) {
            tmp = 0;
            for (int j = i + k - 1; j >= i; j--)
                tmp = (tmp << 1) + (chStr[j] - '0');

            if (!found[tmp]) {
                found[tmp] = true;
                if (--toFind == 0)
                    return true;
            }
        }

        return false;
    }

}
