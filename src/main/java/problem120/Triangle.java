package problem120;

import java.util.List;

public final class Triangle {

    public int minimumTotal(final List<List<Integer>> triangle) {
        final Integer[][] lookup = new Integer[triangle.size()][triangle.get(triangle.size() - 1).size()];
        return recMin(triangle, lookup, 0, 0);
    }

    private int recMin(final List<List<Integer>> triangle, final Integer[][] lookup, final int row, final int pos) {
        if (row == triangle.size())
            return 0;

        if (lookup[row][pos] != null)
            return lookup[row][pos];

        lookup[row][pos] = triangle.get(row).get(pos) + Math.min(recMin(triangle, lookup, row + 1, pos), recMin(triangle, lookup, row + 1, pos + 1));
        return lookup[row][pos];
    }

}
