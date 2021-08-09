package problem1632;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RankTransformMatrixTest {

    private RankTransformMatrix solution = new RankTransformMatrix();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[][]{{1, 2}, {3, 4}}, new int[][]{{1, 2}, {2, 3}}},
                {new int[][]{{7, 7}, {7, 7}}, new int[][]{{1, 1}, {1, 1}}},
                {new int[][]{{20, -21, 14}, {-19, 4, 19}, {22, -47, 24}, {-19, 4, 19}}, new int[][]{{4, 2, 3}, {1, 3, 4}, {5, 1, 6}, {1, 3, 4}}},
                {new int[][]{{7, 3, 6}, {1, 4, 5}, {9, 8, 2}}, new int[][]{{5, 1, 4}, {1, 2, 3}, {6, 3, 1}}},
                {new int[][]{{-23, 20, -49, -30, -39, -28, -5, -14}, {-19, 4, -33, 2, -47, 28, 43, -6}, {-47, 36, -49, 6, 17, -8, -21, -30}, {-27, 44, 27, 10, 21, -8, 3, 14}, {-19, 12, -25, 34, -27, -48, -37, 14}, {-47, 40, 23, 46, -39, 48, -41, 18}, {-27, -4, 7, -10, 9, 36, 43, 2}, {37, 44, 43, -38, 29, -44, 19, 38}},
                        new int[][]{{7, 13, 1, 5, 4, 6, 9, 8}, {8, 11, 2, 10, 1, 12, 14, 9}, {2, 14, 1, 11, 13, 7, 5, 3}, {3, 19, 16, 12, 14, 7, 10, 13}, {8, 12, 6, 14, 5, 1, 4, 13}, {2, 16, 15, 17, 4, 18, 3, 14}, {3, 7, 11, 6, 12, 13, 14, 10}, {16, 19, 18, 3, 15, 2, 11, 17}}}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMatrixRanks(final int[][] matrix, final int[][] expRanks) {
        var actRanks = solution.matrixRankTransform(matrix);

        assertThat(actRanks, is(expRanks));
    }

}
