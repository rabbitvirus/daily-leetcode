package problem714;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BuySellStockTest {

    private BuySellStock solution = new BuySellStock();

    @DataProvider(name = "dp1")
    public static Object[][] provideData() {
        return new Object[][]{
                {new int[]{1, 3, 2, 8, 4, 9}, 2, 8},
                {new int[]{1, 3, 7, 5, 10, 3}, 3, 6}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldMaximizeProfit(final int[] prices, final int fee, final int expProfit) {
        final int actProfit = solution.maxProfit(prices, fee);

        assertThat(actProfit, is(expProfit));
    }
}