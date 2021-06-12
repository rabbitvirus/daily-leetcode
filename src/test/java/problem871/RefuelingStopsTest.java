package problem871;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RefuelingStopsTest {

    private RefuelingStops solution = new RefuelingStops();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {1, 1, new int[][]{}, 0},
                {100, 1, new int[][]{{10, 100}}, -1},
                {100, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}}, 2},
                {100, 50, new int[][]{{50, 50}}, 1},
                {100, 50, new int[][]{{25, 25}, {50, 50}}, 1}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMinimumNumberOfStops(final int target, final int startFuel, final int[][] stations, final int expStops) {
        var actStops = solution.minRefuelStops(target, startFuel, stations);

        assertThat(actStops, is(expStops));
    }

}
