package problem34;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FirstAndLastPositionsTest {

    private FirstAndLastPositions solution = new FirstAndLastPositions();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}},
                {new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1}},
                {new int[]{}, 0, new int[]{-1, -1}}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindFirstAndLastPositionsInSortedArray(final int[] nums, final int target, final int[] expPositions) {
        var actPositions = solution.searchRange(nums, target);

        assertThat(actPositions, is(expPositions));
    }

}
