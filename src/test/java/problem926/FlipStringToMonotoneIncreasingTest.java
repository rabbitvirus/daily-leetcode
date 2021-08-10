package problem926;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class FlipStringToMonotoneIncreasingTest {

    private FlipStringToMonotoneIncreasing solution = new FlipStringToMonotoneIncreasing();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {"00110", 1},
                {"010110", 2},
                {"00011000", 2}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMinNumberOfFlips(final String str, final int expMinFlips) {
        var actMinFlips = solution.minFlipsMonoIncr(str);

        assertThat(actMinFlips, is(expMinFlips));
    }

}
