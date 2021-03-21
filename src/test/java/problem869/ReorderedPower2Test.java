package problem869;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ReorderedPower2Test {

    private ReorderedPower2 solution = new ReorderedPower2();

    @DataProvider(name = "dp1")
    public static Object[][] provideData() {
        return new Object[][]{
                {1, true},
                {10, false},
                {16, true},
                {24, false},
                {46, true}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCheckReorderedPowerOf2(final int n, final boolean expAns) {
        final boolean actAns = solution.reorderedPowerOf2(n);

        assertThat(actAns, is(expAns));
    }

}
