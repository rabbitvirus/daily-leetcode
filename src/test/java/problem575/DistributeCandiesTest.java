package problem575;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class DistributeCandiesTest {

    private DistributeCandies dc = new DistributeCandies();

    @DataProvider(name = "dp1")
    public static Object[][] testData() {
        return new Object[][]{
                {new int[]{1, 1, 2, 2, 3, 3}, 3},
                {new int[]{1, 1, 2, 3}, 2},
                {new int[]{6, 6, 6, 6}, 1}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldDistributeCandies(final int[] candyType, final int expectedDistr) {
        final int d = dc.distributeCandies(candyType);

        assertThat(d, is(expectedDistr));
    }
}