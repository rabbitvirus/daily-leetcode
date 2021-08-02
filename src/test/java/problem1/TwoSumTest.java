package problem1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TwoSumTest {

    private TwoSum solution = new TwoSum();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}},
                {new int[]{3, 2, 4}, 6, new int[]{1, 2}},
                {new int[]{3, 3}, 6, new int[]{0, 1}}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindTwoSumIndexes(final int[] nums, final int target, final int[] expIdx) {
        var actIdx = solution.twoSum(nums, target);

        assertThat(actIdx, is(expIdx));
    }
}
