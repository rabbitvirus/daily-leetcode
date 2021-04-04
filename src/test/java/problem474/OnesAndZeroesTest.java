package problem474;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class OnesAndZeroesTest {

    private OnesAndZeroes solution = new OnesAndZeroes();

    @DataProvider(name = "dp1")
    public static Object[][] provideData() {
        return new Object[][]{
                {new String[]{"10", "0001", "111001", "1", "0"}, 5, 3, 4},
                {new String[]{"10", "0", "1"}, 1, 1, 2}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMaxForm(final String[] strings, final int m, final int n, final int expMax) {
        var actMax = solution.findMaxForm(strings, m, n);

        assertThat(actMax, is(expMax));
    }

}
