package problem667;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BeautifulArrangementIITest {

    private BeautifulArrangementII solution = new BeautifulArrangementII();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {3, 1, new int[]{3, 2, 1}},
                {3, 2, new int[]{3, 1, 2}}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCreateBeautifulArrangement(final int n, final int k, final int[] expArr) {
        var actArr = solution.constructArray(n, k);

        assertThat(actArr, is(expArr));
    }

}
