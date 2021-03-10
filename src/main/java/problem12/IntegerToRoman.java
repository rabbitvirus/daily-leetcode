package problem12;

public final class IntegerToRoman {

    private static final char[] ROMAN_LOOKUP = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};


    public String intToRoman(int num) {
        final StringBuilder sb = new StringBuilder();

        int arrPos = 1;
        int mod;

        while (num > 0) {
            mod = num % 10;

            if (mod <= 3) {
                for (int i = 0; i < mod; i++)
                    sb.append(ROMAN_LOOKUP[arrPos - 1]);
            } else if (mod == 4) {
                sb.append(ROMAN_LOOKUP[arrPos]).append(ROMAN_LOOKUP[arrPos - 1]);
            } else if (mod == 5) {
                sb.append(ROMAN_LOOKUP[arrPos]);
            } else if (mod <= 8) {
                for (int i = 5; i < mod; i++)
                    sb.append(ROMAN_LOOKUP[arrPos - 1]);
                sb.append(ROMAN_LOOKUP[arrPos]);
            } else {
                sb.append(ROMAN_LOOKUP[arrPos + 1]).append(ROMAN_LOOKUP[arrPos - 1]);
            }

            arrPos += 2;
            num /= 10;
        }

        return sb.reverse().toString();
    }
}
