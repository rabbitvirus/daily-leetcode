package problem322;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class CoinChangeTest {

    private CoinChange solution = new CoinChange();

    @DataProvider(name = "dp1")
    public static Object[][] provideTestData() {
        return new Object[][]{
                {new int[]{1, 2, 5}, 11, 3},
                {new int[]{2}, 3, -1},
                {new int[]{1}, 0, 0},
                {new int[]{1}, 1, 1},
                {new int[]{1}, 2, 2}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldChangeCoins(final int[] coins, final int amount, final int expMoves) {
        var actMoves = solution.coinChange(coins, amount);

        assertThat(actMoves, is(expMoves));
    }
}
