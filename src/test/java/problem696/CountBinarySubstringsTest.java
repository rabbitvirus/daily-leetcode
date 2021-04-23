package problem696;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CountBinarySubstringsTest {

    private CountBinarySubstrings solution = new CountBinarySubstrings();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][] {
                {"00110011", 6},
                {"10101", 4}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCountBinarySubstrings(final String str, final int expCnt) {
        var actCnt = solution.countBinarySubstrings(str);

        assertThat(actCnt, is(expCnt));
    }

}
