package problem1354;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MultiSumArrayTest {

    private MultiSumArray solution = new MultiSumArray();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{9, 3, 5}, true},
                {new int[]{1, 1, 1, 2}, false},
                {new int[]{8, 5}, true}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCheckMultiSumArray(final int[] arr, final boolean expRes) {
        var actRes = solution.isPossible(arr);

        assertThat(actRes, is(expRes));
    }

}
