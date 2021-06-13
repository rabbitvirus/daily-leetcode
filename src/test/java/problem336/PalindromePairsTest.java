package problem336;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PalindromePairsTest {

    private PalindromePairs solution = new PalindromePairs();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new String[]{"abcd", "dcba", "lls", "s", "sssll"}, List.of(List.of(0, 1), List.of(1, 0), List.of(3, 2), List.of(2, 4))},
                {new String[]{"bat", "tab", "cat"}, List.of(List.of(0, 1), List.of(1, 0))},
                {new String[]{"a", ""}, List.of(List.of(0, 1), List.of(1, 0))}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindAllDistinctPalindromePairs(final String[] words, final List<List<Integer>> expPairs) {
        var actPairs = solution.palindromePairs(words);

        assertThat(new HashSet<>(actPairs), is(new HashSet<>(expPairs)));
    }

}
