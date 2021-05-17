package problem1048;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LongestStringChainTest {

    private LongestStringChain solution = new LongestStringChain();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new String[]{"a", "b", "ba", "bca", "bda", "bdca"}, 4},
                {new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"}, 5},
                {new String[]{"a","ab","ac","bd","abc","abd","abdd"}, 4}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindLongestStringChainLength(final String[] words, final int expLen) {
        var actLen = solution.longestStrChain(words);

        assertThat(actLen, is(expLen));
    }
}
