package problem792;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NumberOfMatchingSubsequencesTest {

    private NumberOfMatchingSubsequences solution = new NumberOfMatchingSubsequences();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {"abcde", new String[]{"a", "bb", "acd", "ace"}, 3},
                {"dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"}, 2}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindNumberOfMatchingSubsequences(final String str, final String[] words, final int expCnt) {
        var actCnt = solution.numMatchingSubseq(str, words);

        assertThat(actCnt, is(expCnt));
    }
}
