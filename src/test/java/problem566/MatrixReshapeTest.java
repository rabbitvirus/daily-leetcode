package problem566;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MatrixReshapeTest {

    private MatrixReshape solution = new MatrixReshape();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[][]{{1, 2}, {3, 4}}, 1, 4, new int[][]{{1, 2, 3, 4}}},
                {new int[][]{{1, 2}, {3, 4}}, 2, 4, new int[][]{{1, 2}, {3, 4}}}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldReshapeTheMatrix(final int[][] matrix, final int r, final int c, final int[][] expMatrix) {
        var actMatrix = solution.matrixReshape(matrix, r, c);

        assertThat(actMatrix, is(expMatrix));
    }

}
