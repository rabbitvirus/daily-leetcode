package problem746;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MinCostClimbingStairsTest {

    private MinCostClimbingStairs solution = new MinCostClimbingStairs();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{10, 15, 20}, 15},
                {new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}, 6}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMinNumberOfSteps(final int[] cost, final int expSteps) {
        var actSteps = solution.minCostClimbingStairs(cost);

        assertThat(actSteps, is(expSteps));
    }

}
