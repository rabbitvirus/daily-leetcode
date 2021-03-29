package problem647;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PalindromicSubstringsTest {

    private PalindromicSubstrings solution = new PalindromicSubstrings();

    @DataProvider(name = "dp1")
    public static Object[][] provideData() {
        return new Object[][]{
                {"abc", 3},
                {"aaa", 6}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCountPalindromicSubstrings(final String str, final int expCnt) {
        var actCnt = solution.countSubstrings(str);

        assertThat(actCnt, is(expCnt));
    }
}
