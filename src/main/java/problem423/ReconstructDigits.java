package problem423;

public final class ReconstructDigits {

    private static final int N_CHAR = 'z' - 'a' + 1;

    public String originalDigits(final String s) {
        final int[] charCnt = new int[N_CHAR];
        for (int i = 0; i < s.length(); i++)
            charCnt[s.charAt(i) - 'a']++;

        final int[] outCnt = new int[10];
        outCnt[0] = charCnt['z' - 'a'];
        outCnt[2] = charCnt['w' - 'a'];
        outCnt[6] = charCnt['x' - 'a'];
        outCnt[8] = charCnt['g' - 'a'];
        outCnt[7] = charCnt['s' - 'a'];
        outCnt[3] = charCnt['h' - 'a'];
        outCnt[5] = charCnt['v' - 'a'];
        outCnt[4] = charCnt['f' - 'a'];
        outCnt[1] = charCnt['o' - 'a'];
        outCnt[9] = charCnt['n' - 'a'];

        outCnt[7] -= outCnt[6];
        outCnt[3] -= outCnt[8];
        outCnt[5] -= outCnt[7];
        outCnt[4] -= outCnt[5];
        outCnt[1] = outCnt[1] - outCnt[0] - outCnt[2] - outCnt[4];
        outCnt[9] = (outCnt[9] - outCnt[1] - outCnt[7]) / 2;


        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < outCnt.length; i++)
            for (int j = 0; j < outCnt[i]; j++)
                sb.append(i);

        return sb.toString();
    }

}
