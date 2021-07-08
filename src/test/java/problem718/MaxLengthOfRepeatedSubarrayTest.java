package problem718;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MaxLengthOfRepeatedSubarrayTest {

    private MaxLengthOfRepeatedSubarray solution = new MaxLengthOfRepeatedSubarray();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}, 3},
                {new int[5], new int[5], 5},
                {new int[5], new int[3], 3},
                {new int[]{1, 2, 4, 3, 2, 1}, new int[]{2, 1, 2, 6, 6, 3, 2, 1, 5}, 3}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMaxLenSubarray(final int[] left, final int[] right, final int expRes) {
        var actRes = solution.findLength(left, right);

        assertThat(actRes, is(expRes));
    }

}
