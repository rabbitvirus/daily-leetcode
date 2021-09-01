package problem565;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class ArrayNestingTest {

    private ArrayNesting solution = new ArrayNesting();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{5, 4, 0, 3, 1, 6, 2}, 4},
                {new int[]{0, 1, 2}, 1}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindTheLongestPath(final int[] nums, final int expLen) {
        var actLen = solution.arrayNesting(nums);

        assertThat(actLen, is(expLen));
    }

}
