package problem363;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MaxSumOfRectangleNoLargerThanKTest {

    private MaxSumOfRectangleNoLargerThanK solution = new MaxSumOfRectangleNoLargerThanK();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[][]{{1, 0, 1}, {0, -2, 3}}, 2, 2},
                {new int[][]{{2, 2, -1}}, 3, 3}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMaxArea(final int[][] matrix, final int k, final int expArea) {
        var acrArea = solution.maxSumSubmatrix(matrix, k);

        assertThat(acrArea, is(expArea));
    }

}
