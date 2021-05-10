package problem204;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CountPrimesTest {

    private CountPrimes solution = new CountPrimes();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {10, 4},
                {0, 0},
                {1, 0}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCountPrimes(final int n, final int expCnt) {
        var actCnt = solution.countPrimes(n);

        assertThat(actCnt, is(expCnt));
    }
}
