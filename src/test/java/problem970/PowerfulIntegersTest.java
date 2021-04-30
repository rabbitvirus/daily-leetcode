package problem970;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PowerfulIntegersTest {

    private PowerfulIntegers solution = new PowerfulIntegers();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {2, 3, 10, List.of(2, 3, 4, 5, 7, 9, 10)},
                {3, 5, 15, List.of(2, 4, 6, 8, 10, 14)}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindAllPowerfulIntegers(final int x, final int y, final int bound, final List<Integer> expList) {
        var actList = solution.powerfulIntegers(x, y, bound);

        assertThat(actList, is(expList));
    }

}
