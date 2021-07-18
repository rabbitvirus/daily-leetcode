package problem927;

public final class ThreeEqualParts {

    public int[] threeEqualParts(final int[] arr) {
        final int n = arr.length;

        // count all ones
        int ones = 0;
        for (int i = 0; i < n; i++)
            if (arr[i] == 1)
                ones++;

        // quick check for 'corner' cases
        if (ones == 0)
            return new int[]{0, n - 1};
        else if (ones % 3 != 0)
            return new int[]{-1, -1};

        final int onesPerPart = ones / 3;
        final int[] splits = new int[2];

        // find initial split positions
        int pos = 0;
        for (int i = 0; i < 2; i++) {
            int sOnes = 0;
            while (sOnes < onesPerPart)
                if (arr[pos++] == 1)
                    sOnes++;
            splits[i] = pos;
        }

        // count trailing zeros in the last part
        int trZeros = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 1)
                break;
            trZeros++;
        }

        // try to update positions based on trailing zeros info
        for (int i = 0; i < 2; i++) {
            int sPos = splits[i];
            int sZero = 0;
            while (sZero < trZeros) {
                if (arr[sPos] == 1)
                    return new int[]{-1, -1};
                sZero++;
                sPos++;
            }
            splits[i] = sPos - 1;
        }

        // verify if all 3 numbers are the same
        for (int i = splits[0], j = splits[1], k = n - 1, lastOnesFound = 0; lastOnesFound < onesPerPart; i--, j--, k--) {
            if (i < 0 || arr[i] != arr[j] || arr[j] != arr[k])
                return new int[]{-1, -1};

            if (arr[k] == 1)
                lastOnesFound++;
        }

        splits[1] += 1;
        return splits;
    }

}
