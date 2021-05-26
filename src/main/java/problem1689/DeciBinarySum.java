package problem1689;

public final class DeciBinarySum {

    public int minPartitions(final String n) {
        char max = '0';
        for (var c : n.toCharArray()) {
            if (max < c)
                max = c;

            if (max == '9')
                return 9;
        }
        return max - '0';
    }

}
