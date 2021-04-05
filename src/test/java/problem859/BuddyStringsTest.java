package problem859;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BuddyStringsTest {

    private BuddyStrings solution = new BuddyStrings();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {"ab", "ba", true},
                {"ab", "ab", false},
                {"aa", "aa", true},
                {"aaaaaaabc", "aaaaaaacb", true}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCheckBuddyStrings(final String strA, final String strB, final boolean expResult) {
        var actResult = solution.buddyStrings(strA, strB);

        assertThat(actResult, is(expResult));
    }

}
