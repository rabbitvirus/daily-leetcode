package problem415;

public final class AddStrings {

    public String addStrings(final String num1, final String num2) {
        final int len1 = num1.length();
        final int len2 = num2.length();

        final char[] ch1 = num1.toCharArray();
        final char[] ch2 = num2.toCharArray();
        final char[] res = new char[Math.max(len1, len2) + 1];

        boolean carry = false;
        int r = res.length - 1;

        for (int p1 = num1.length() - 1, p2 = num2.length() - 1; p1 >= 0 || p2 >= 0 || carry; p1--, p2--, r--) {
            var c1 = p1 >= 0 ? ch1[p1] - '0' : 0;
            var c2 = p2 >= 0 ? ch2[p2] - '0' : 0;
            var sum = c1 + c2 + (carry ? 1 : 0);
            carry = sum >= 10;
            res[r] = (char) (sum % 10 + '0');
        }

        return new String(res, r + 1, res.length - r - 1);
    }

}
