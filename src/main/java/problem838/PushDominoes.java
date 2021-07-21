package problem838;

public final class PushDominoes {

    public String pushDominoes(final String dominoes) {
        final char[] dominoesArr = dominoes.toCharArray();
        final int n = dominoesArr.length;

        char prev = '.';
        for (int i = 0; i < n; i++) {
            if ((prev == 'R' || prev == '*') && dominoesArr[i] == '.')
                dominoesArr[i] = '*';
            prev = dominoesArr[i];
        }

        prev = '.';
        for (int i = n - 1; i >= 0; ) {
            var cur = dominoesArr[i];

            if (cur == '*') {
                if (prev == 'L') {
                    int cnt = 1;
                    while (dominoesArr[i - 1] == '*') {
                        --i;
                        ++cnt;
                    }

                    int mid = cnt / 2;
                    int j;
                    for (j = i; j < i + mid; j++)
                        dominoesArr[j] = 'R';

                    if (cnt % 2 != 0)
                        dominoesArr[j++] = '.';

                    for (int k = j; k < j + mid; k++)
                        dominoesArr[k] = 'L';

                } else {
                    dominoesArr[i] = 'R';
                    while (dominoesArr[i - 1] == '*') {
                        dominoesArr[i - 1] = 'R';
                        i--;
                    }
                }
            } else if (cur == '.' && prev == 'L') {
                dominoesArr[i] = 'L';
            }

            prev = dominoesArr[i];
            i--;
        }

        return new String(dominoesArr);
    }

}
