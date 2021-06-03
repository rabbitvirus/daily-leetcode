package problem1465;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MaximumPieceOfCakeAreaTest {

    private MaximumPieceOfCakeArea solution = new MaximumPieceOfCakeArea();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {5, 4, new int[]{1, 2, 4}, new int[]{1, 3}, 4},
                {5, 4, new int[]{3, 1}, new int[]{1}, 6},
                {5, 4, new int[]{3}, new int[]{3}, 9}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMaxArea(final int h, final int w, final int[] hCuts, final int[] vCuts, final int expArea) {
        var actArea = solution.maxArea(h, w, hCuts, vCuts);

        assertThat(actArea, is(expArea));
    }
}
