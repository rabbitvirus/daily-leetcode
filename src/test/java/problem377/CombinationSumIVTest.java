package problem377;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CombinationSumIVTest {

    private CombinationSumIV solution = new CombinationSumIV();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{1, 2, 3}, 4, 7},
                {new int[]{9}, 3, 0}
        };
    }

    @Test(dataProvider = "dp1")
    private void shouldFindAllCombinationsThatSumToTarget(final int[] nums, final int target, final int expCnt) {
        var actCnt = solution.combinationSum4(nums, target);

        assertThat(actCnt, is(expCnt));
    }

}
