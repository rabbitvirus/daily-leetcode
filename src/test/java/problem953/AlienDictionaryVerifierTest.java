package problem953;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AlienDictionaryVerifierTest {

    private AlienDictionaryVerifier solution = new AlienDictionaryVerifier();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz", true},
                {new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz", false},
                {new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz", false}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldVerifyAlienDictionary(final String[] words, final String dict, final boolean expResult) {
        var actResult = solution.isAlienSorted(words, dict);

        assertThat(actResult, is(expResult));
    }

}
