package problem537;

public final class ComplexNumberMultiplication {

    public String complexNumberMultiply(final String num1, final String num2) {
        var c1 = strToComplex(num1);
        var c2 = strToComplex(num2);

        var re = c1.re * c2.re - c1.im * c2.im;
        var im = c1.re * c2.im + c1.im * c2.re;

        return "" + re + '+' + im + 'i';
    }

    private static ComplexNum strToComplex(final String str) {
        final char[] ch = str.toCharArray();
        int i = 0;

        // re
        final int reCoeff = ch[i] == '-' ? -1 : 1;
        int re = 0;
        for (i = (reCoeff > 0 ? 0 : 1); '0' <= ch[i] && ch[i] <= '9'; i++)
            re = 10 * re + ch[i] - '0';
        re *= reCoeff;

        // im
        i++;
        final int imCoeff = ch[i] == '-' ? -1 : 1;
        int im = 0;
        for (i = (imCoeff > 0 ? i : i + 1); i < ch.length && '0' <= ch[i] && ch[i] <= '9'; i++)
            im = 10 * im + ch[i] - '0';
        im *= imCoeff;

        return new ComplexNum(re, im);
    }

    private static final class ComplexNum {
        private final int re;
        private final int im;

        ComplexNum(final int re, final int im) {
            this.re = re;
            this.im = im;
        }
    }

}
