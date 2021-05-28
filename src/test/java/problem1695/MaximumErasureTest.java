package problem1695;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MaximumErasureTest {

    private MaximumErasure solution = new MaximumErasure();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{4, 2, 4, 5, 6}, 17},
                {new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}, 8}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindSumOfMaximumErasure(final int[] nums, final int expSum) {
        var actSum = solution.maximumUniqueSubarray(nums);

        assertThat(actSum, is(expSum));
    }
}
