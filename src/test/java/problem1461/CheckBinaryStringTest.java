package problem1461;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CheckBinaryStringTest {

    private CheckBinaryString solution = new CheckBinaryString();

    @DataProvider(name = "dp1")
    public static Object[][] testData() {
        return new Object[][]{
                {"00110110", 2, true},
                {"00110", 2, true},
                {"0110", 1, true},
                {"0110", 2, false},
                {"0000000001011100", 4, false},
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCheckIfStringHasAllCodes(final String inStr, final int k, final boolean expResult) {
        final boolean actResult = solution.hasAllCodes(inStr, k);

        assertThat(actResult, is(expResult));
    }

}
