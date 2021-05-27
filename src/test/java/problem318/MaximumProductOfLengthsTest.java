package problem318;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class MaximumProductOfLengthsTest {

    private MaximumProductOfLengths solution = new MaximumProductOfLengths();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}, 16},
                {new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}, 4},
                {new String[]{"a", "aa", "aaa", "aaaa"}, 0}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMaximumProductOfWordLengths(final String[] words, final int expLen) {
        var actLen = solution.maxProduct(words);

        assertThat(actLen, is(expLen));
    }

}
