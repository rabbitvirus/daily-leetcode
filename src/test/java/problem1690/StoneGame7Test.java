package problem1690;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StoneGame7Test {

    private StoneGame7 solution = new StoneGame7();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{5, 3, 1, 4, 2}, 6},
                {new int[]{7, 90, 5, 1, 100, 10, 10, 2}, 122}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindOptimalDifference(final int[] stones, final int expDiff) {
        var actDiff = solution.stoneGameVII(stones);

        assertThat(actDiff, is(expDiff));
    }

}
