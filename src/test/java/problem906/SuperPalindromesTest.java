package problem906;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SuperPalindromesTest {

    private SuperPalindromes solution = new SuperPalindromes();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {"4", "1000", 4},
                {"1", "2", 1}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCountSuperPalindromes(final String left, final String right, final int expCnt) {
        var actCnt = solution.superpalindromesInRange(left, right);

        assertThat(actCnt, is(expCnt));
    }

}
