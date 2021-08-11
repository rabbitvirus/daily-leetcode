package problem954;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ArrayOfDoubledPairsTest {

    private ArrayOfDoubledPairs solution = new ArrayOfDoubledPairs();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{50001, 50002}, false},
                {new int[]{-6, -3}, true},
                {new int[]{3, 1, 3, 6}, false},
                {new int[]{2, 1, 2, 6}, false},
                {new int[]{4, -2, 2, -4}, true},
                {new int[]{1, 2, 4, 16, 8, 4}, false}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCheckIfReorderingIsPossible(final int[] arr, final boolean expCanReorder) {
        var actCanReorder = solution.canReorderDoubled(arr);

        assertThat(actCanReorder, is(expCanReorder));
    }
}
