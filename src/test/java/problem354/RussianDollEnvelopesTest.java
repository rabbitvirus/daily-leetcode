package problem354;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RussianDollEnvelopesTest {

    private RussianDollEnvelopes solution = new RussianDollEnvelopes();

    @DataProvider(name = "dp1")
    public static Object[][] provideData() {
        return new Object[][]{
                {new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}, 3},
                {new int[][]{{1, 1}, {1, 1}, {1, 1}}, 1}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMaxEnvelopes(final int[][] envelopes, final int expMax) {
        var actMax = solution.maxEnvelopes(envelopes);

        assertThat(actMax, is(expMax));
    }

}
