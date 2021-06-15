package problem473;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MatchsticksToSquareTest {

    private MatchsticksToSquare solution = new MatchsticksToSquare();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{1, 1, 2, 2, 2}, true},
                {new int[]{3, 3, 3, 3, 4}, false}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCheckIfAllMatchSticksCanCreateSquare(final int[] m, final boolean expAns) {
        var actAns = solution.makesquare(m);

        assertThat(actAns, is(expAns));
    }

}