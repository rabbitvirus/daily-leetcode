package problem97;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class InterleavingStringTest {

    private InterleavingString solution = new InterleavingString();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {"aabcc", "dbbca", "aadbbcbcac", true},
                {"aabcc", "dbbca", "aadbbbaccc", false},
                {"", "", "", true}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCheckInterleavingStrings(final String str1, final String str2, final String str3, final boolean expRes) {
        var actRes = solution.isInterleave(str1, str2, str3);

        assertThat(actRes, is(expRes));
    }

}
