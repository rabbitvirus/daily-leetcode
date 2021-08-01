package problem827;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class MakingALargeIslandTest {

    private MakingALargeIsland solution = new MakingALargeIsland();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[][]{{1, 0}, {0, 1}}, 3},
                {new int[][]{{1, 1}, {1, 0}}, 4},
                {new int[][]{{1, 1}, {1, 1}}, 4},
                {new int[][]{{0, 0}, {0, 0}}, 1},
                {new int[][]{{1}}, 1},
                {new int[][]{{0, 0}, {0, 1}}, 2}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMaxArea(final int[][] grid, final int expMaxArea) {
        var actMaxArea = solution.largestIsland(grid);

        assertThat(actMaxArea, is(expMaxArea));
    }
}
