package problem63;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UniquePathsIITest {

    private UniquePathsII solution = new UniquePathsII();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}, 2},
                {new int[][]{{0, 1}, {0, 0}}, 1}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindAllUniquePaths(final int[][] grid, final int expCnt) {
        var actCnt = solution.uniquePathsWithObstacles(grid);

        assertThat(actCnt, is(expCnt));
    }

}
