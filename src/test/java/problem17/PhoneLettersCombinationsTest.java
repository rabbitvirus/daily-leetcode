package problem17;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PhoneLettersCombinationsTest {

    private PhoneLettersCombinations solution = new PhoneLettersCombinations();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {"23", Set.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")},
                {"", Set.of()},
                {"2", Set.of("a", "b", "c")}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindAllLettersCombinations(final String inStr, final Set<String> expCombinations) {
        var actComb = solution.letterCombinations(inStr);

        var actCombSet = new HashSet<>(actComb);

        assertThat(actCombSet, is(expCombinations));
    }
}
