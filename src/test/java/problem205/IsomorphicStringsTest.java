package problem205;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class IsomorphicStringsTest {

    private IsomorphicStrings solution = new IsomorphicStrings();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {"badc", "baba", false},
                {"egg", "add", true},
                {"foo", "bar", false},
                {"paper", "title", true}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCheckIfStringsAreIsomorphic(final String left, final String right, final boolean isIso) {
        var actIso = solution.isIsomorphic(left, right);

        assertThat(actIso, is(isIso));
    }

}
