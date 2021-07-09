package problem300;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LongestIncreasingSubsequenceTest {

    private LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{4, 10, 4, 3, 8, 9}, 3},
                {new int[]{10, 9, 2, 5, 3, 7, 101, 18}, 4},
                {new int[]{0, 1, 0, 3, 2, 3}, 4},
                {new int[]{7, 7, 7, 7, 7}, 1}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindLIS(final int[] arr, final int expLen) {
        var actLen = solution.lengthOfLIS(arr);

        assertThat(actLen, is(expLen));
    }
}
