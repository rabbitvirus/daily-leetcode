package problem775;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GlobalLocalInversionsTest {

    private GlobalLocalInversions solution = new GlobalLocalInversions();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[]{1, 0, 2}, true},
                {new int[]{1, 2, 0}, false}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCheckPermutation(final int[] perm, final boolean expCheck) {
        var actCheck = solution.isIdealPermutation(perm);

        assertThat(actCheck, is(expCheck));
    }

}
