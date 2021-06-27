package problem315;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SmallerNumbersTest {

    private SmallerNumbers solution = new SmallerNumbers();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{5, 2, 6, 1}, List.of(2, 1, 1, 0)},
                {new int[]{-1}, List.of(0)},
                {new int[]{-1, -1}, List.of(0, 0)}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindSmallNumbersCountArray(final int[] nums, final List<Integer> expAns) {
        var actAns = solution.countSmaller(nums);

        assertThat(actAns, is(expAns));
    }

}
