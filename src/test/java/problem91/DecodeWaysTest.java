package problem91;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DecodeWaysTest {

    private DecodeWays solution = new DecodeWays();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {"12", 2},
                {"226", 3},
                {"0", 0},
                {"06", 0},
                {"10", 1},
                {"2101", 1}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindNumberOfWaysToDecode(final String str, final int expNum) {
        var actNum = solution.numDecodings(str);

        assertThat(actNum, is(expNum));
    }

}
