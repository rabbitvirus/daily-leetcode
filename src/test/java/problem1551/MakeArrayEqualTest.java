package problem1551;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MakeArrayEqualTest {

    private MakeArrayEqual solution = new MakeArrayEqual();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {3, 2},
                {6, 9}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCalcMinOperationsToMakeTheArrayEqual(final int n, final int expMin) {
        var actMin = solution.minOperations(n);

        assertThat(actMin, is(expMin));
    }

}
