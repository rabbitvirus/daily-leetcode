package problem639;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DecodeWays2Test {

    private DecodeWays2 solution = new DecodeWays2();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {"2839", 1},
                {"7777", 1},
                {"126", 3},
                {"*1", 11},
                {"*1*1*0", 404},
                {"91", 1},
                {"3*", 9},
                {"*", 9},
                {"1*", 18},
                {"2*", 15}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindNumberOfDecodingWays(final String in, final int expCnt) {
        var actCnt = solution.numDecodings(in);

        assertThat(actCnt, is(expCnt));
    }

}
