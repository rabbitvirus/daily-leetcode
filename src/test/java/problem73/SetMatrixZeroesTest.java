package problem73;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SetMatrixZeroesTest {

    private SetMatrixZeroes solution = new SetMatrixZeroes();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}, new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}},
                {new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}}, new int[][]{{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}}},
                {new int[][]{{1, 2, 3, 4}, {5, 0, 7, 8}, {0, 10, 11, 12}, {13, 14, 15, 0}}, new int[][]{{0, 0, 3, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldZeroMatrix(final int[][] matrix, final int[][] expMatrix) {
        solution.setZeroes(matrix);

        assertThat(matrix, is(expMatrix));
    }

}
