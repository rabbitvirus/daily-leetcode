package problem132;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PalindromePartitioningIITest {

    private PalindromePartitioningII solution = new PalindromePartitioningII();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {"aab", 1},
                {"a", 0},
                {"ab", 1},
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMinNumberOfCuts(final String str, final int expMin) {
        var actMin = solution.minCut(str);

        assertThat(actMin, is(expMin));
    }

}
