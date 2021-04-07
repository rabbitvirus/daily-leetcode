package problem1704;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AlikeStringHalvesTest {

    private AlikeStringHalves solution = new AlikeStringHalves();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {"book", true},
                {"textbook", false},
                {"MerryChristmas", false},
                {"AbCdEfGh", true}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCheckIfStringHalvesAreAlike(final String str, final boolean expResult) {
        var actResult = solution.halvesAreAlike(str);

        assertThat(actResult, is(expResult));
    }

}
