package problem376;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class WiggleSubsequenceTest {

    private WiggleSubsequence solution = new WiggleSubsequence();

    @DataProvider(name = "dp1")
    public static Object[][] provideData() {
        return new Object[][]{
                {new int[]{1, 7, 4, 9, 2, 5}, 6},
                {new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}, 7},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 2}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMaxWiggleSubsequenceLength(final int[] nums, final int expLen) {
        final int actLen = solution.wiggleMaxLength(nums);

        assertThat(actLen, is(expLen));
    }

}
