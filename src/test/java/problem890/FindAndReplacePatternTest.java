package problem890;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FindAndReplacePatternTest {

    private FindAndReplacePattern solution = new FindAndReplacePattern();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb", List.of("mee", "aqq")},
                {new String[]{"a", "b", "c"}, "a", List.of("a", "b", "c")}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindAndReplacePatternPermutation(final String[] words, final String pattern, final List<String> expResult) {
        var actResult = solution.findAndReplacePattern(words, pattern);

        assertThat(actResult, is(expResult));
    }

}
