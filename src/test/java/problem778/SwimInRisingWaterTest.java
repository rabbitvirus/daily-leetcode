package problem778;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SwimInRisingWaterTest {

    private SwimInRisingWater solution = new SwimInRisingWater();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[][]{{0, 2}, {1, 3}}, 3},
                {new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}}, 16}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMinWaterFlow(final int[][] grid, final int expMin) {
        var actMin = solution.swimInWater(grid);

        assertThat(actMin, is(expMin));
    }

}
