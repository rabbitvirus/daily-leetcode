package problem1696;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class JumpGameVITest {

    private JumpGameVI solution = new JumpGameVI();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{1, -1, -2, 4, -7, 3}, 2, 7},
                {new int[]{10, -5, -2, 4, 0, 3}, 3, 17},
                {new int[]{1, -5, -20, 4, -1, 3, -6, -3}, 2, 0}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMaxSum(final int[] nums, final int k, final int expSum) {
        var actSum = solution.maxResult(nums, k);

        assertThat(actSum, is(expSum));
    }

}
