package problem916;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class WordSubsetsTest {

    private WordSubsets solution = new WordSubsets();

    @DataProvider(name = "dp1")
    public static Object[][] provideData() {
        return new Object[][]{
                {new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"e", "o"}, List.of("facebook", "google", "leetcode")},
                {new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"l", "e"}, List.of("apple", "google", "leetcode")},
                {new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"e", "oo"}, List.of("facebook", "google")},
                {new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"lo", "eo"}, List.of("google", "leetcode")},
                {new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"ec", "oc", "ceo"}, List.of("facebook", "leetcode")}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindWordSubsets(final String[] a, final String[] b, final List<String> expSubsets) {
        final List<String> actSubsets = solution.wordSubsets(a, b);

        assertThat(actSubsets, is(expSubsets));
    }
}
