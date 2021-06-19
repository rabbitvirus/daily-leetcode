package problem629;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class KInversePairsTest {

    private KInversePairs solution = new KInversePairs();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {3, 0, 1},
                {3, 1, 2},
                {1, 0, 1},
                {1000, 1000, 663677020}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindNumberOfArrays(final int n, final int k, final int expCnt) {
        var actCnt = solution.kInversePairs(n, k);

        assertThat(actCnt, is(expCnt));
    }

}
