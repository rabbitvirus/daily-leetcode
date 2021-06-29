package problem1004;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MaximumConsecutiveOnesTest {

    private MaximumConsecutiveOnes solution = new MaximumConsecutiveOnes();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2, 6},
                {new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3, 10},
                {new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 0, 4}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMaxLen(final int[] nums, final int k, final int expN) {
        var actN = solution.longestOnes(nums, k);

        assertThat(actN, is(expN));
    }

}
