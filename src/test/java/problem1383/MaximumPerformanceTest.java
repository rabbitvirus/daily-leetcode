package problem1383;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MaximumPerformanceTest {

    private MaximumPerformance solution = new MaximumPerformance();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 2, 60},
                {6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 3, 68},
                {6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 4, 72}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMaxPerformance(final int n, final int[] speed, final int[] eff, final int k, final int expMax) {
        var actMax = solution.maxPerformance(n, speed, eff, k);

        assertThat(actMax, is(expMax));
    }
}
