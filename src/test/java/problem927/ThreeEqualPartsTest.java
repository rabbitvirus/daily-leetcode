package problem927;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ThreeEqualPartsTest {

    private ThreeEqualParts solution = new ThreeEqualParts();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{1, 0, 1, 0, 1}, new int[]{0, 3}},
                {new int[]{1, 1, 0, 1, 1}, new int[]{-1, -1}},
                {new int[]{1, 1, 0, 0, 1}, new int[]{0, 2}}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldSplitArrayIntoThreeEqualBinaryParts(final int[] arr, final int[] expPos) {
        var actPos = solution.threeEqualParts(arr);

        assertThat(actPos, is(expPos));
    }

}
