package problem32;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LongestValidParenthesesTest {

    private LongestValidParentheses solution = new LongestValidParentheses();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {"(()", 2},
                {")()())", 4},
                {"", 0}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCountLongestValidParentheses(final String inStr, final int expCnt) {
        var actCnt = solution.longestValidParentheses(inStr);

        assertThat(actCnt, is(expCnt));
    }

}
