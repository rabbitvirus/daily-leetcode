package problem326;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PowerOfThreeTest {

    private PowerOfThree solution = new PowerOfThree();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {27, true},
                {0, false},
                {9, true},
                {45, false}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCheckPowerOfThree(final int n, final boolean expRes) {
        var actRes = solution.isPowerOfThree(n);

        assertThat(actRes, is(expRes));
    }

}
