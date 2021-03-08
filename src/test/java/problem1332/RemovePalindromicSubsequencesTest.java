package problem1332;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RemovePalindromicSubsequencesTest {

    private RemovePalindromicSubsequences solution = new RemovePalindromicSubsequences();

    @DataProvider(name = "dp1")
    public static Object[][] provideTestData() {
        return new Object[][]{
                {"ababa", 1},
                {"abb", 2},
                {"baabb", 2},
                {"", 0},
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCountRemovePalindromeSubsequences(final String inStr, final int expMoves) {
        final int actMoves = solution.removePalindromeSub(inStr);

        assertThat(actMoves, is(expMoves));
    }

}
