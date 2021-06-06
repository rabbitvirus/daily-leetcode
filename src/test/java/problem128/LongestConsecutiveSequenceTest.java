package problem128;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LongestConsecutiveSequenceTest {

    private LongestConsecutiveSequence solution = new LongestConsecutiveSequence();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{100, 4, 200, 1, 3, 2}, 4},
                {new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}, 9}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindLenOfLongestConsecutiveSequence(final int[] nums, final int expLen) {
        var actLen = solution.longestConsecutive(nums);

        assertThat(actLen, is(expLen));
    }
}
